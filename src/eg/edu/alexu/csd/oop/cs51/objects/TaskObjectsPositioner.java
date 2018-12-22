package eg.edu.alexu.csd.oop.cs51.objects;

import java.util.List;

import eg.edu.alexu.csd.oop.cs51.objects.constant.TaskObject;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class TaskObjectsPositioner {
    private static final int SCREEN_WIDTH = 1366;
    
    public static void position(List<Task> tasks) {
        int noTasks = tasks.size();
        int xPos = SCREEN_WIDTH / 2 - noTasks * 250 / 2;
        for(Task task: tasks) {
            task.getTaskObject().setX(xPos); 
            task.getTaskObject().setY(5);
            xPos += 250;
        }
    }
}
