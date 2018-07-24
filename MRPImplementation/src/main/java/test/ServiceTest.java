package test;

import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;
import com.coding.mrpImplementation.service.ServiceImpl;
import org.junit.Before;

import java.util.ArrayList;

public class ServiceTest{
    ArrayList<Machine> machines=new ArrayList<>();
    ArrayList<Activity> activities=new ArrayList<>();
    ArrayList<Material> materials=new ArrayList<>();
    Service service= ServiceImpl.getInstance();
    public ServiceTest(){
    }

    @Before
    public void setUp() throws MRPException{
        Machine machine;
        Material material;
        Activity activity;

        for (int i=0;i<5;i++){
            machine=new Machine("M"+i,"Maquina "+i+1+" de Cafe");
            service.addMachine(machine);
            machines.add(machine);
        }
        for (int i=0;i<6;i++){
            activity =new Activity("A"+i,"Activity "+i);
            service.addActivity(activity);
            activities.add(activity);
        }
        for (int i=0;i<5;i++){
            int initialInventoryOnHand=(int) (Math.random()*(19-(26))+25);
            int orderingCost=(int) (Math.random()*(4-(10))+9);
            int maintainCost=(int) (Math.random()*(2-(201))+200);
            int securityStock=(int)(Math.random()*(1-(9))+8);
            int sizeOfLot=(int)(Math.random()*(1-(11))+10);
            int availablePrev=(int)(Math.random()*(1-(9))+8);
            int period=(int)(Math.random()*(7));
            material =new Material("MT"+i,"Material "+i,initialInventoryOnHand,orderingCost,maintainCost,securityStock,sizeOfLot,availablePrev,period);
            service.addMaterial(material);
            materials.add(material);
        }

        for (Machine i:machines){
            int activitiesQ=(int) (Math.random()*(activities.size()+1));
            for(int j=0;j<activitiesQ;j++){
                int activityIndex=(int) (Math.random()*(activities.size()+1));
                i.setActivity(activities.get(activityIndex));
                activities.get(activityIndex).setMachines(i);
            }
        }
        for (Activity i:activities){
            int materialsQ=(int) (Math.random()*(materials.size()+1));
            for(int j=0;j<materialsQ;j++){
                int materialIndex=(int) (Math.random()*(materials.size()+1));
                i.setMaterial(materials.get(materialIndex));
                materials.get(materialIndex).setActivity(i);
            }
        }

    }


}