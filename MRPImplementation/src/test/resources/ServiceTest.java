package test;

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
        Machine machine;
        Material material;
        Activity activity;

        for (int i=0;i<5;i++){
            machine=new Machine("M"+(i+1),"Maquina "+(i+1)+" de Cafe");
            service.addMachine(machine);
            machines.add(machine);
        }
        for (int i=0;i<6;i++){
            activity =new Activity("A"+(i+1),"Activity "+(i+1));
            service.addActivity(activity);
            activities.put(i,activity);
        }
        for (int i=0;i<5;i++){
            int initialInventoryOnHand=(int) (Math.random()*(7)+19);
            int orderingCost=(int) (Math.random()*(6)+4);
            int maintainCost=(int) (Math.random()*(199)+2);
            int securityStock=(int)(Math.random()*(8)+1);
            int sizeOfLot=(int)(Math.random()*(10)+1);
            int availablePrev=(int)(Math.random()*(8)+1);
            int period=(int)(Math.random()*(7));
            material =new Material("MT"+(i+1),"Material "+(i+1),initialInventoryOnHand,orderingCost,maintainCost,securityStock,sizeOfLot,availablePrev,period);
            service.addMaterial(material);
            materials.add(material);
        }

        for (Machine i:machines){
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

        }



    }

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


        HashMap<Material,int[]> materialsPlanning =service.plaining("LotForLot");
        System.out.println(materialsPlanning);
        for(Material i:materialsPlanning.keySet()){
            materialsPlanning.get(i);
            System.out.printf("Material %s%n ",i.getId());
            for(int j=0;j<materialsPlanning.get(i).length;j++){
                System.out.printf(" %d ---> %d",j,materialsPlanning.get(i)[j]);
            }
            System.out.printf("%n");
        }
        assert(true);
    }
}