public class Main {
    public static void main(String[] args) {
        ElectronFactory factory = new ElectronFactory();
        ElectricalApp headphones = factory.getElectronApp(ElectronTypes.HEADPHONES);
        ElectricalApp speaker = factory.getElectronApp(ElectronTypes.SPEAKER);
        ElectricalApp camera = factory.getElectronApp(ElectronTypes.CAMERA);

        headphones.device();
        speaker.device();
        camera.device();
    }
    public static class ElectronFactory {
        public ElectricalApp getElectronApp(ElectronTypes type){
            ElectricalApp ToReturn = null;
            switch (type){
                case HEADPHONES -> ToReturn = new Headphones();
                case SPEAKER -> ToReturn = new Speaker();
                case CAMERA -> ToReturn = new Camera();
                default -> throw new IllegalArgumentException("Wrong doughnut type:" + type);

            }
            return ToReturn;
        }
    }
    public interface ElectricalApp{
        void device();
    }
    public static class Headphones implements ElectricalApp{
        @Override
        public void device(){
            System.out.println("You got a new headphones");
        }
    }
    public static class Speaker implements ElectricalApp{
        @Override
        public void device(){
            System.out.println("You got a new speaker");
        }
    }
    public static class Camera implements ElectricalApp{
        @Override
        public void device(){
            System.out.println("You got a new camera");
        }
    }
    public enum ElectronTypes {
        HEADPHONES,
        SPEAKER,
        CAMERA
    }
}