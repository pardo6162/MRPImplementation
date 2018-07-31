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
    private Activity activity;
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
        activity = new Activity("A1","Activity 1 ");
        service.addActivity(activity);

        //add machine
        machine = new Machine("M1","Machine 1");
        service.addMachine(machine);

        //add material to activity
        service.addMaterialToActivity(material.getId(),activity.getId(),5);

        //add activity to machine
        service.addAcivityToMachine(activity.getId(),machine.getId());

        //add shedule to activity
        activity.addSchedule(machine,1);
        activity.addSchedule(machine,5);
        service.updateActivity(activity.getId(),activity);
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
        int [] validRequirement=new int[]{0,5,0,0,0,5,0};
        for(int i=0;i< time;i++){
            assertEquals("Requirement of material is incorrect",validRequirement[i],service.getRequirementOfMaterial(i,material));
        }
    }

    @Test
    public void inventoryOnHandTest() throws MRPException{
        int time=service.getTime();
        int [] validInventoryOnHand = new int[]{19,14,14,14,14,9,9};
        for(int i=0;i<time; i++){
            assertEquals("inventory on hand is incorrect",validInventoryOnHand[i],service.getInventoryOnHand(i,material));
        }
    }

    @Test
    public void updateInventoryOnHandTest() throws MRPException{
        int time=service.getTime();
        int [] validInventoryOnHand = new int[]{19,14,14,14,14,9,9};
        int [] validUpdateInventoryOnHand = new int[]{20,16,17,18,19,15,16};
        for(int i=0;i<time; i++){
            assertEquals("Inventory on hand is incorrect ",validInventoryOnHand[i],service.getInventoryOnHand(i,material));
            service.updateInventoryOnHand(i,material,i+1);
            assertEquals("Update Inventory on hand is incorrect ",validUpdateInventoryOnHand[i],service.getInventoryOnHand(i,material));
        }
    }

    @Test
    public void netRequirementTest() throws MRPException{
        int time=service.getTime();
        int [] validUpdateInventoryOnHand = new int[]{20,16,17,18,19,15,16};
        int [] validNetRequirement =new int []{0,2,1,0,0,3,2};
        for(int i=0;i<time; i++){
            assertEquals("Inventory on hand is incorrect ",validUpdateInventoryOnHand[i],service.getInventoryOnHand(i,material));
            assertEquals("Net requirement is incorrect ",validNetRequirement[i],service.getNetRequirement(i,material));
        }
    }

    @Test
    public void requirementOfActivityTest() throws MRPException{
        int time=service.getTime();
        int [] validRequirementOfActivity =new int []{0,1,0,0,0,1,0};
        for(int i=0;i<time; i++){
            assertEquals("Inventory on hand is incorrect ",validRequirementOfActivity[i],service.getRequirementOfActivity(activity.getId(),i));
        }
    }






    



    /**
    void addMachine(Machine machine) throws MRPException;
    void addAcivityToMachine(String idActivity,String idMachine) throws MRPException;
    void addMaterialToActivity(String idMaterial,String idActivity,int quantity) throws MRPException;
    ArrayList<Machine> getMachines() throws MRPException;
    ArrayList<Activity> getActivities() throws MRPException;
    ArrayList<Material> getMaterials() throws MRPException;
    void addMaterial(Material material) throws MRPException;
    void addActivity(Activity activity) throws MRPException;
    void updateActivity(String activityId,Activity activity)throws  MRPException;**/
}