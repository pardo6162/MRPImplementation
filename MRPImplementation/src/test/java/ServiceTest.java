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
        int securityStock= 3;//(int)(Math.random()*(8)+1);
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



    /**
    @Test
    public void correctConfig() throws MRPException{
        for(Machine i:service.getMachines()){
            System.out.printf("Machine %s %n----Activities: %n",i.getId());
            for(Activity j:i.getActivities()){
                System.out.printf("------Activity %s %n--------Materials: %n",j.getId());

                for(Material k:j.getMaterials()){
                    System.out.printf("----------Material %s %n",k.getId());
                }

            }

        }
        System.out.println("--------------------------------------------------------------");
        for(Activity i:activities.values()){

            System.out.printf("Activity %s %n----Schedule:%n",i.getId());
            for(Machine j:i.getCalendar().keySet()){
                System.out.printf("------Machine:%s%n--------",j.getId());
                for(Integer k:i.getCalendar().get(j)){
                    System.out.printf("%d ",k);
                }
                System.out.printf("%n");
            }
        }



        assert(true);
    }

    @Test
    public void createActivityVsMachine() throws MRPException{
        Machine machine;
        Material material;
        Activity activity;

        for (int i=0;i<1;i++){
            machine=new Machine("M"+(i+1),"Maquina "+(i+1)+" de Cafe");
            service.addMachine(machine);
        }
        for (int i=0;i<1;i++){
            activity =new Activity("A"+(i+1),"Activity "+(i+1));
            service.addActivity(activity);
        }
        //for (int i=0;i<1;i++){
        int initialInventoryOnHand= 19;//(int) (Math.random()*(7)+19);
        int orderingCost= 5;//(int) (Math.random()*(6)+4);
        int maintainCost= 56;//(int) (Math.random()*(199)+2);
        int securityStock= 3;//(int)(Math.random()*(8)+1);
        int sizeOfLot=(int) 9;//(Math.random()*(10)+1);
        int availablePrev= 3;//(int)(Math.random()*(8)+1);
        int period= 5;//(int)(Math.random()*(7));
        System.out.printf("----------------------------------------%n" +
                "initialInventoryOnHand %d%n " +
                "orderingCost %d%n" +
                " maintainCost %d%n" +
                " securityStock %d%n" +
                " sizeOfLot %d%n " +
                "availablePrev %d%n" +
                " period %d%n" +
                "------------------------------------%n",initialInventoryOnHand,orderingCost,maintainCost,securityStock,sizeOfLot,availablePrev,period);

        service.addMaterial(material);

        for (Machine i:service.getMachines()) {
            System.out.printf("Machine %s%n",i.getId());
            int activitiesQ = (int) (Math.random() * (activities.size()) + 1);
            for (int j = 0; j < activitiesQ; j++) {
                int activityIndex = 0;
                //(int) (Math.random() * (activities.size()));
                int cantIndexTime =2;// (int) (Math.random() * 7) + 1;
                Activity activityTemp = service.getActivities().get(activityIndex);
                service.addAcivityToMachine(activityTemp.getId(),i.getId());
                System.out.printf("----Activity %s%n",activityTemp.getId());
                //System.out.println(cantIndexTime+" nnnnnnnnnnnnnnnnnnnnnnnnn");
                int[] numbers={5,1};
                for (int k = 0; k < cantIndexTime; k++) {
                    int indexTime = numbers[k];// (int) (Math.random() * 7) + 1;
                    System.out.println(activityTemp.getCalendar());
                    activityTemp.addSchedule(i, indexTime);
                }
                service.addMaterialToActivity("MT1","A1",5);
                activityTemp=service.getActivities().get(0);
                System.out.println("Materials "+service.getActivities().get(0).getMaterials());
                service.updateActivity(activityTemp.getId(),activityTemp);
                System.out.println("cale nda "+activityTemp.getCalendar());
                System.out.println(service.getActivities().get(0).getCalendar()+"calnedarr");
            }


            HashMap<Material,int[]> materialsPlanning =service.plaining("LotForLot");
            //System.out.println(materialsPlanning);
            //System.out.println(materialsPlanning);
            for(Material k:materialsPlanning.keySet()){
                //System.out.println("----------------------------"+materialsPlanning.get(k));
                System.out.printf("Material %s%n ",k.getId());
                for(int j=0;j<materialsPlanning.get(k).length;j++){
                    System.out.printf(" %d ---> %d",j,materialsPlanning.get(k)[j]);
                }
                System.out.printf("%n");
            }
        }

        for(Activity i:service.getActivities()){
            System.out.println(i);
            System.out.printf("Activity %s%n",i.getId());
            System.out.printf("----Schedule%n------%s%n",i.getCalendar().toString());
        }
    }**/

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
        for(int i=0;i< service.getTime();i++){
            assertEquals("Requirement of material is incorrect",validRequirement[i],service.getRequirementOfMaterial(i,material));
        }
    }

    @Test
    public void inventoryOnHandTest() throws MRPException{
        
    }



    /**
     * int getInventoryOnHand(int timeIndex,Material material) throws  MRPException;
    void updateInventoryOnHand(int timeIndex, Material material,int plannedReceptions) throws MRPException;
    HashMap<Material,int[]> plaining(String lotMethod) throws MRPException;
    int getNetRequirement(int timeIndex,Material material) throws MRPException;
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