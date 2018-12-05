import com.coding.mrpImplementation.MRP.exception.MRPException;
import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;
import com.coding.mrpImplementation.service.impl.ServiceImpl;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class    ServiceTest{
    private static Company company = new Company();
    private static Service service;
    private Material material;
    private Activity activity1;
    private Machine machine;

    public ServiceTest(){
    }

    @Before
    public void setUp() throws MRPException {}
/**
        // add material
        int initialInventoryOnHand= 19;//(int) (Math.random()*(7)+19);
        int orderingCost= 5;//(int) (Math.random()*(6)+4);
        int maintainCost= 56;//(int) (Math.random()*(199)+2);
        int securityStock= 18;//(int)(Math.random()*(8)+1);
        int sizeOfLot=9;//(Math.random()*(10)+1);
        int availablePrev= ;//(int)(Math.random()*(8)+1);
        int period= 5;//(int)(Math.random()*(7));
        material =new Material("MT1","Material "+(1),initialInventoryOnHand,orderingCost,maintainCost,securityStock,sizeOfLot,availablePrev,period);

        activity1 = new Activity("A1","Activity 1 ");
        activity1.setMaterial(material,5);
        activity1.addSchedule(machine,1);
        activity1.addSchedule(machine,5);
        //add machine
        machine = new Machine("M1","Machine 1");
        machine.setActivity(activity1);
        company.addMachine(machine);
        service= ServiceImpl.getInstance(company);
        service.addProgramedReceptions(0,material,3);
    }
**/
    /**
    @Test
    public  void planningTest() throws MRPException{
        int time=company.getTime();
        HashMap<Material,int[]> result;
        int [] planningInventory;
        int [] inventoryOnHand;
        int [] netRequirement;

        //Lot Method 1

        service.resetInventoryOnHand();
        planningInventory= new int[]{18,0,0,0,0,0,0};//{0,9,0,0,9,9,0};
        inventoryOnHand= new int[]{18,18,18,18,18,18,0};//{19,23,18,18,22,26,26};
        result=service.planning("LotForLot");
        for(int[] list:result.values())
            for(int i=0;i<time;i++){
                assertEquals("The lot method Lot for Lot is incorrect"+i,planningInventory[i],list[i]);
                assertEquals("The inventory on hand of method Lot for Lot is incorrect"+i,inventoryOnHand[i],service.getInventoryOnHand(i,material));
            }


        //Lot Method 2
        service.resetInventoryOnHand();
        planningInventory= new int[]{18,5,0,0,0,5,0};
        inventoryOnHand= new int[]{18,18,18,18,18,18,18};
        result=service.planning("FOQ");
        System.out.println(result.get(material));
        for(int[] list:result.values())
           for(int i=0;i<time;i++) {
               assertEquals("The lot method FOQ Lot is incorrect" , planningInventory[i], list[i]);
               assertEquals("The inventory on hand of method FOQ is incorrect",inventoryOnHand[i],service.getInventoryOnHand(i,material));
           }

        //Lot Method 3
        service.resetInventoryOnHand();
        planningInventory= new int[]{5,5,5,5,5,0,0};
        inventoryOnHand= new int[]{5,5,10,15,20,15,15};
        result=service.planning("BPF");
        for(int[] list:result.values())
           for(int i=0;i<time;i++){
               assertEquals("The lot method BPF Lot is incorrect"+i,planningInventory[i],list[i]);
               assertEquals("The inventory on hand of method BPF is incorrect"+i,inventoryOnHand[i],service.getInventoryOnHand(i,material));
           }

        //Lot Method 4
        service.resetInventoryOnHand();
        planningInventory= new int[]{-14,-14,-9,-9,-9,-9,-4};
        inventoryOnHand= new int[]{3,-2,-2,-2,-2,-7,-7};
        netRequirement= new int[]{15,20,20,20,20,25,25};
        result=service.planning("ConstantPeriod");
        for(int[] list:result.values())
            for(int i=0;i<time;i++) {
                assertEquals("The lot method Constant Period Lot is incorrect" + i, planningInventory[i], list[i]);
                assertEquals("The inventory on hand of method Constant Period is incorrect" + i, inventoryOnHand[i], service.getInventoryOnHand(i, material));
                assertEquals("The net requirement of Constant Period is incorrect" + i, netRequirement[i], service.getNetRequirement(i, material));
            }

        //Lot Method 5
        service.resetInventoryOnHand();
        planningInventory= new int[]{18,5,0,0,0,5,0};
        inventoryOnHand= new int[]{18,18,18,18,18,18,18};
        netRequirement= new int[]{0,0,0,0,0,0,0};
        result=service.planning("EOQ");
        for(int[] list:result.values())
            for(int i=0;i<time;i++) {
                assertEquals("The lot method EOQ is incorrect" + i, planningInventory[i], list[i]);
                assertEquals("The inventory on hand of method EOQ is incorrect"+i,inventoryOnHand[i],service.getInventoryOnHand(i,material));
                assertEquals("The net requirement of  EOQ is incorrect"+i,netRequirement[i],service.getNetRequirement(i,material));
            }

        //Lot Method 6
        service.resetInventoryOnHand();
        planningInventory= new int[]{5,0,0,0,5,0,0};
        inventoryOnHand= new int[]{5,0,0,0,5,0,0};
        netRequirement= new int[]{13,18,18,18,13,18,18};
        result=service.planning("MCU");
        for(int[] list:result.values())
            for(int i=0;i<time;i++) {
                assertEquals("The lot method MCU is incorrect" + i, planningInventory[i], list[i]);
                assertEquals("The inventory on hand of method MCU is incorrect"+i,inventoryOnHand[i],service.getInventoryOnHand(i,material));
                assertEquals("The net requirement of MCU is incorrect"+i,netRequirement[i],service.getNetRequirement(i,material));
            }

        //Lot Method 7
        service.resetInventoryOnHand();
        planningInventory= new int[]{-11,-11,-11,-11,-11,-11,-11};
        inventoryOnHand= new int[]{-8,-24,-35,-46,-57,-73,-84};
        netRequirement= new int[]{26,42,53,64,75,91,102};
        result=service.planning("POQ");
        for(int[] list:result.values())
            for(int i=0;i<time;i++) {
                assertEquals("The lot method POQ is incorrect" + i, planningInventory[i], list[i]);
                assertEquals("The inventory on hand of method POQ is incorrect"+i,inventoryOnHand[i],service.getInventoryOnHand(i,material));
                assertEquals("The net requirement of POQ is incorrect"+i,netRequirement[i],service.getNetRequirement(i,material));
            }


         //Lot Method 8
        service.resetInventoryOnHand();
        planningInventory= new int[]{5,0,0,0,5,0,0};
        inventoryOnHand= new int[]{5,0,0,0,5,0,0};
        netRequirement= new int[]{13,18,18,18,13,18,18};
        result=service.planning("SilverMeal");
        for(int[] list:result.values())
            for(int i=0;i<time;i++) {
                assertEquals("The lot method Silver Meal is incorrect" + i, planningInventory[i], list[i]);
                assertEquals("The inventory on hand of method Silver Meal is incorrect"+i,inventoryOnHand[i],service.getInventoryOnHand(i,material));
                assertEquals("The net requirement of  Silver Meal is incorrect"+i,netRequirement[i],service.getNetRequirement(i,material));
            }
    }


    @Test
    public void getTimeTest() throws MRPException {
        assertEquals("the time is incorrect",7,service.getTime());
    }

    @Test
    public void programedReceptionsTest() throws  MRPException{
        int [] validProgramedReceptions=new int[]{3,0,0,0,0,0,0};
        for(int i=0;i< service.getTime();i++){
            assertEquals("programed Receptions are incorrect ",validProgramedReceptions[i],service.getProgramedReceptions(i,material));
        }
    }

    /**@Test
    public void requirementOfMaterialTest() throws MRPException{
        int time=company.getTime();
        int [] validRequirement=new int[]{5,0,0,0,0,5,0};
        for(int i=0;i< time;i++){
            assertEquals("Requirement of material is incorrect"+i,validRequirement[i],service.getRequirementOfMaterial(i,material));
        }
    }**/
    /**
    @Test
    public void inventoryOnHandTest() throws MRPException{
        int time=company.getTime();
        int [] validInventoryOnHand = new int[]{5,0,0,0,5,0,0};
        for(int i=0;i<time; i++){
            assertEquals("inventory on hand is incorrect "+ i,validInventoryOnHand[i],service.getInventoryOnHand(i,material));
        }
    }**/
    /**
    @Test
    public void updateInventoryOnHandTest() throws MRPException{
        int time=company.getTime();
        int [] validInventoryOnHand = new int[]{5,1,3,6,5,5,11};
        int [] validUpdateInventoryOnHand = new int[]{6,3,6,10,10,11,18};
        for(int i=0;i<time; i++){
            assertEquals("Inventory on hand is incorrect ",validInventoryOnHand[i],service.getInventoryOnHand(i,material));
            service.updateInventoryOnHand(i,material,i+1);
            assertEquals("Update Inventory on hand is incorrect ",validUpdateInventoryOnHand[i],service.getInventoryOnHand(i,material));
        }
    }**/
    /**
    @Test
    public void netRequirementTest() throws MRPException{
        int time=company.getTime();
        int [] validUpdateInventoryOnHand = new int[]{6,3,6,10,10,11,18};
        int [] validNetRequirement =new int []{12,15,12,8,8,7,0,0};
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
        }
    }

    **/

}