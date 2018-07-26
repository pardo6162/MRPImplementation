import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;
import com.coding.mrpImplementation.service.ServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceTest{
    ArrayList<Machine> machines=new ArrayList<>();
    HashMap<Integer,Activity> activities=new HashMap<>();
    ArrayList<Material> materials=new ArrayList<>();
    private static Service service= ServiceImpl.getInstance(7);
    public ServiceTest(){
    }

    @Before
    public void setUp() throws MRPException{

        }

        /**for (Machine i:machines){
            int activitiesQ=(int) (Math.random()*(activities.size())+1);
            for(int j=0;j<activitiesQ;j++){
                int activityIndex=(int) (Math.random()*(activities.size()));
                int cantIndexTime=(int) (Math.random()*7)+1;
                Activity activityTemp=activities.get(activityIndex);
                for(int k=0;k<cantIndexTime;k++){
                    int indexTime=(int) (Math.random()*7)+1;
                    activityTemp.addSchedule(i,indexTime);
                }
                activityTemp.setMachines(i);
                i.setActivity(activityTemp);
                activities.remove(activityIndex);
                activities.put(activityIndex,activityTemp);
            }
        }
        for (Activity i:activities.values()){
            int materialsQ=(int) (Math.random()*(materials.size())+1);
            for(int j=0;j<materialsQ;j++){
                int materialIndex=(int) (Math.random()*(materials.size()));
                i.setMaterial(materials.get(materialIndex));
                materials.get(materialIndex).setActivity(i);
            }

        }**/



    //  }
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
**/
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
        material =new Material("MT"+(1),"Material "+(1),initialInventoryOnHand,orderingCost,maintainCost,securityStock,sizeOfLot,availablePrev,period);
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
                int[] numbers={6,2};
                for (int k = 0; k < cantIndexTime; k++) {
                    int indexTime = numbers[k];// (int) (Math.random() * 7) + 1;
                    System.out.println(activityTemp.getCalendar());
                    activityTemp.addSchedule(i, indexTime);
                }

                activityTemp=service.getActivities().get(0);
                service.updateActivity(activityTemp.getId(),activityTemp);
                System.out.println("cale nda "+activityTemp.getCalendar());
                System.out.println(service.getActivities().get(0).getCalendar()+"calnedarr");
            }

            service.addMaterialToActivity("MT1","M1",5);
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
    }

    @Test
    public void createActivityVsTime(){

    }

    @Test
    public void createActivityVsMaterial(){

    }
    @Test
    public void MRPTest(){

    }
    @Test
    public void unitTest(){

    }
}