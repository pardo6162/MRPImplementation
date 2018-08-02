import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;
import com.coding.mrpImplementation.service.ServiceImpl;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class ServiceTest{
    ArrayList<Machine> machines=new ArrayList<>();
    HashMap<Integer,Activity> activities=new HashMap<>();
    ArrayList<Material> materials=new ArrayList<>();
    private static Service service= ServiceImpl.getInstance(7);
    private Material material;
    private Activity activity1;
    private Activity activity2;
    private Machine machine;

    public ServiceTest(){
    }

    @Before
    public void setUp() throws MRPException{

        // add material
        int initialInventoryOnHand= 19;//(int) (Math.random()*(7)+19);
        int orderingCost= 5;//(int) (Math.random()*(6)+4);
        int maintainCost= 56;//(int) (Math.random()*(199)+2);
        int securityStock= 18;//(int)(Math.random()*(8)+1);
        int sizeOfLot=(int) 9;//(Math.random()*(10)+1);
        int availablePrev= 3;//(int)(Math.random()*(8)+1);
        int period= 5;//(int)(Math.random()*(7));
        material =new Material("MT1","Material "+(1),initialInventoryOnHand,orderingCost,maintainCost,securityStock,sizeOfLot,availablePrev,period);
        service.addMaterial(material);

        //add activity
        activity1 = new Activity("A1","Activity 1 ");
        service.addActivity(activity1);

        activity2 = new Activity("A2","Activity 2 ");
        service.addActivity(activity2);

        //add machine
        machine = new Machine("M1","Machine 1");
        service.addMachine(machine);

        //add material to activity
        service.addMaterialToActivity(material.getId(),activity1.getId(),5);
        service.addMaterialToActivity(material.getId(),activity2.getId(),5);

        //add activity to machine
        service.addAcivityToMachine(activity1.getId(),machine.getId());
        service.addAcivityToMachine(activity2.getId(),machine.getId());

        //add shedule to activity
        activity1.addSchedule(machine,1);
        activity1.addSchedule(machine,5);
        service.updateActivity(activity1.getId(),activity1);

        activity2.addSchedule(machine,2);
        activity2.addSchedule(machine,4);
        service.updateActivity(activity2.getId(),activity2);
    }


    @Test
    public  void planningTest() throws MRPException{
        int time=service.getTime();
        HashMap<Material,int[]> result;
        int [] planningInventory;
        //Lot Method 1
        service.resetInventoryOnHand();
        planningInventory= new int[]{0,9,0,0,9,9,0};
        result=service.planning("LotForLot");
        for(int[] list:result.values())
            for(int i=0;i<time;i++)
                assertEquals("The lot method Lot for Lot is incorrect"+i,planningInventory[i],list[i]);
        
        /**
         //Lot Method 2
         planningInventory= new int[]{0,0,0,0,0,0,0,};
         result=service.planning("FOQ");
         //Lot Method 3
         planningInventory= new int[]{};
         result=service.planning("BPF");
         //Lot Method 4
         planningInventory= new int[]{};
         result=service.planning("ConstantPeriod");
         //Lot Method 5
         planningInventory= new int[]{};
         result=service.planning("EOQ");
         //Lot Method 6
         planningInventory= new int[]{};
         result=service.planning("MCU");
         //Lot Method 7
         planningInventory= new int[]{};
         result=service.planning("POQ");
         //Lot Method 8
         planningInventory= new int[]{};
         result=service.planning("SilverMeal");**/
        service.resetInventoryOnHand();
    }


    @Test
    public void getTimeTest() throws MRPException {
        assertEquals("the time is incorrect",7,service.getTime());
    }

    @Test
    public void programedReceptionsTest() throws  MRPException{
        for(int i=0;i< service.getTime();i++){
            assertEquals("programed Receptions are incorrect ",0,service.getProgramedReceptions(i,material));
        }
    }

    @Test
    public void requirementOfMaterialTest() throws MRPException{
        int time=service.getTime();
        int [] validRequirement=new int[]{0,5,5,0,5,5,0};
        for(int i=0;i< time;i++){
            assertEquals("Requirement of material is incorrect",validRequirement[i],service.getRequirementOfMaterial(i,material));
        }
    }

    @Test
    public void inventoryOnHandTest() throws MRPException{
        int time=service.getTime();
        int [] validInventoryOnHand = new int[]{19,14,9,9,4,-1,-1};
        for(int i=0;i<time; i++){
            assertEquals("inventory on hand is incorrect "+ i,validInventoryOnHand[i],service.getInventoryOnHand(i,material));
        }
    }

    @Test
    public void updateInventoryOnHandTest() throws MRPException{
        int time=service.getTime();
        int [] validInventoryOnHand = new int[]{19,14,9,9,4,-1,-1};
        int [] validUpdateInventoryOnHand = new int[]{20,16,12,13,9,5,6};
        for(int i=0;i<time; i++){
            assertEquals("Inventory on hand is incorrect ",validInventoryOnHand[i],service.getInventoryOnHand(i,material));
            service.updateInventoryOnHand(i,material,i+1);
            assertEquals("Update Inventory on hand is incorrect ",validUpdateInventoryOnHand[i],service.getInventoryOnHand(i,material));
        }
    }

    @Test
    public void netRequirementTest() throws MRPException{
        int time=service.getTime();
        int [] validUpdateInventoryOnHand = new int[]{20,16,12,13,9,5,6};
        int [] validNetRequirement =new int []{0,2,6,5,9,13,12,12};
        for(int i=0;i<time; i++){
            assertEquals("Inventory on hand is incorrect ",validUpdateInventoryOnHand[i],service.getInventoryOnHand(i,material));
            assertEquals("Net requirement is incorrect ",validNetRequirement[i],service.getNetRequirement(i,material));
        }
    }

    @Test
    public void requirementOfActivityTest() throws MRPException{
        int time=service.getTime();
        int [] validRequirementOfActivity1 =new int []{0,1,0,0,0,1,0};
        int [] validRequirementOfActivity2 =new int []{0,0,1,0,1,0,0};
        for(int i=0;i<time; i++){
            assertEquals("Requirement of activity 1 is incorrect ",validRequirementOfActivity1[i],service.getRequirementOfActivity(activity1.getId(),i));
            assertEquals("Requirement of activity 2 is incorrect ",validRequirementOfActivity2[i],service.getRequirementOfActivity(activity2.getId(),i));
        }
    }




}