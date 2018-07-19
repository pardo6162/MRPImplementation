public class ServiceTest{
    private Service service;

    public ServiceTest(){
    }

    @Before
    public void setUp(){
        service=new ServiceImpl();
        //load machines
        Machine machine;
        Activity activity;
        Material material;
        ArrayList<Machine> machines=new ArrayList<>();
        ArrayList<Activity> activities=new ArrayList<>();
        ArrayList<Material> materials=new ArrayList<>();

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
            Random rand = new Random;
            int numerOfInventory=rand.nextInt(7)+19;
            int orderingCost=rand.nextInt(6)+4;
            int maintainCost=rand.nextInt(199)+2;
            material = new Material("MAT"+1,"Material "+i,numerOfInventory,orderingCost,maintainCost);
            materials.add(material);
        }
        service.get

    }


}