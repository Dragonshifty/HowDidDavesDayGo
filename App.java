public class App {


    public static void main(String[] args) throws Exception {

        WorkingDay workingDay = new WorkingDay();
        // for (int i = 0;  i < 100; i++){
        workingDay.staffArrive();
        workingDay.morningShift();
        workingDay.lunchShift();
        workingDay.afternoonShift();
        // }
        // workingDay.runTesting();
    }
}
