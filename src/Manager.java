import java.util.HashMap;

public class Manager {
    protected HashMap<Integer, Task> listOfTask = new HashMap<>();
    protected HashMap<Integer, Epic> listOfEpic = new HashMap<>();
    protected HashMap<Integer, Subtask> listOfSubtask = new HashMap<>();

    protected  int guid = 1;

    public int createTask(Task task) {
        task.setUid(guid++);
        listOfTask.put(task.getUid(),task);
        return task.getUid();
    }

    public int createEpic(Epic epic) {
        epic.setUid(guid++);
        listOfEpic.put(epic.getUid(),epic);
        return epic.getUid();
    }

    public int createSubtask(Subtask subtask) {
        subtask.setUid(guid++);
        listOfSubtask.put(subtask.getUid(),subtask);
        listOfEpic.get(subtask.getEpicID()).addSubtask(subtask.getUid());
        listOfEpic.get(subtask.getEpicID()).setStatus("NEW");
        return subtask.getUid();
    }

    public HashMap<Integer,Task> getAllTasc() {
        return listOfTask;
    }

    public HashMap<Integer,Epic> getAllEpic() {
        return listOfEpic;
    }

    public HashMap<Integer,Subtask> getAllSubtasc() {
        return listOfSubtask;
    }

    public Boolean deleteTaskById(int id) {
        listOfTask.remove(id);
        return true;
    }

    public Boolean clearAllTasc() {
        listOfTask.clear();
        return true;
    }

    public Boolean deleteSubtaskById(int id) {
        int index = listOfEpic.get(listOfSubtask.get(id).getEpicID()).subtasksIds.indexOf(id);

        listOfEpic.get(listOfSubtask.get(id).getEpicID()).subtasksIds.remove(index);
        updateEpicStatus(listOfSubtask.get(id).getEpicID());
        listOfSubtask.remove(id);
        return true;
    }

    protected void updateEpicStatus(int id) {
        if (listOfEpic.get(id).subtasksIds.isEmpty()) {
            listOfEpic.get(id).setStatus("NEW");
            return;
        }

        boolean hasNEW = false;
        boolean hasDONE = false;

        for (int i = 0; i < listOfEpic.get(id).subtasksIds.size(); i++) {
            if (listOfSubtask.get(listOfEpic.get(id).subtasksIds.get(i)).getStatus().equals("NEW")) {
                hasNEW = true;
            } else if (listOfSubtask.get(listOfEpic.get(id).subtasksIds.get(i)).getStatus().equals("DONE")) {
                hasDONE = true;
            }
        }

        if (hasDONE && hasNEW) {
            listOfEpic.get(id).setStatus("IN_PROGRESS");
        } else if (hasNEW && !hasDONE) {
            listOfEpic.get(id).setStatus("NEW");
        } else if (!hasNEW && hasDONE) {
            listOfEpic.get(id).setStatus("DONE");
        }
    }

    public Boolean clearAllSubtasc() {
        for (Integer id : listOfTask.keySet()) {
            deleteSubtaskById(id);
        }
        return true;
    }

    public boolean deleteEpicById(int id) {
        for (int i = 0; i < listOfEpic.get(id).subtasksIds.size(); i++) {
            listOfSubtask.remove(listOfEpic.get(id).subtasksIds.get(i));
        }

        listOfEpic.remove(id);
        return true;
    }

    public Boolean clearAllEpic() {
        listOfEpic.clear();
        listOfSubtask.clear();
        return true;
    }

    public HashMap<Integer,Subtask> getAllSubtasksByEpicId(int id) {
        HashMap<Integer,Subtask> list = new HashMap<>();

        if (listOfEpic.get(id).subtasksIds.isEmpty()) return list;

        for (int i = 0; i < listOfEpic.get(id).subtasksIds.size(); i++) {
            list.put(listOfEpic.get(id).subtasksIds.get(i),
                    listOfSubtask.get(listOfEpic.get(id).subtasksIds.get(i)));
        }
        return list;
    }

    public Task getTaskById(int id) {
        return listOfTask.get(id);
    }

    public Epic getEpicById(int id) {
        return listOfEpic.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return listOfSubtask.get(id);
    }

    public Boolean updateTask(Task tasc) {
        listOfTask.get(tasc.getUid()).setName(tasc.getName());
        listOfTask.get(tasc.getUid()).setDescription(tasc.getDescription());
        listOfTask.get(tasc.getUid()).setStatus(tasc.getStatus());
        return true;
    }

    public Boolean updateEpic(Epic epic) {
        listOfEpic.get(epic.getUid()).setName(epic.getName());
        listOfEpic.get(epic.getUid()).setDescription(epic.getDescription());
        updateEpicStatus(epic.getUid());
        return true;
    }

    public Boolean updateSubtask(Subtask sub) {
        listOfSubtask.get(sub.getUid()).setName(sub.getName());
        listOfSubtask.get(sub.getUid()).setDescription(sub.getDescription());
        listOfSubtask.get(sub.getUid()).setStatus(sub.getStatus());

        updateEpicStatus(listOfSubtask.get(sub.getUid()).epicID);
        return true;
    }
}
