public class Main { //этот класс создан для отладки

    public static void main(String[] args) {

        Manager manager = new Manager();

        String name = "таск1";
        String description = "описание_таски1";
        Task task = new Task(name,description);
        int id = manager.createTask(task);
        System.out.println(manager.listOfTask.get(task.getUid()).getUid() + " "
                + manager.listOfTask.get(task.getUid()).getName() + " "
                + manager.listOfTask.get(task.getUid()).getDescription() + " "
                + manager.listOfTask.get(task.getUid()).getStatus());

        name = "таск2";
        description = "описание_таски2";
        Task task2 = new Task(name,description);
        id = manager.createTask(task2);
        System.out.println(manager.listOfTask.get(task2.getUid()).getUid() + " "
                + manager.listOfTask.get(task2.getUid()).getName() + " "
                + manager.listOfTask.get(task2.getUid()).getDescription() + " "
                + manager.listOfTask.get(task2.getUid()).getStatus());

        System.out.println();
        System.out.println("Список тасков" + manager.listOfTask);

        name = "эпик1";
        description = "описание_эпика1";
        Epic epic = new Epic(name,description);
        id = manager.createEpic(epic);
        System.out.println(manager.listOfEpic.get(epic.getUid()).getUid() + " "
                + manager.listOfEpic.get(epic.getUid()).getName() + " "
                + manager.listOfEpic.get(epic.getUid()).getDescription() + " "
                + manager.listOfEpic.get(epic.getUid()).getStatus() + " "
                + !manager.listOfEpic.get(epic.getUid()).subtasksIds.isEmpty());

        name = "эпик2";
        description = "описание_эпика2";
        Epic epic2 = new Epic(name,description);
        id = manager.createEpic(epic2);
        System.out.println(manager.listOfEpic.get(epic2.getUid()).getUid() + " "
                + manager.listOfEpic.get(epic2.getUid()).getName() + " "
                + manager.listOfEpic.get(epic2.getUid()).getDescription() + " "
                + manager.listOfEpic.get(epic2.getUid()).getStatus() + " "
                + !manager.listOfEpic.get(epic2.getUid()).subtasksIds.isEmpty());

        System.out.println();
        System.out.println("Список эпиков" + manager.listOfEpic);


        name = "сабтаск1";
        description = "описание_сабтаск1";
        int epicId = epic.getUid();
        Subtask subtask = new Subtask(name,description,epicId);
        manager.createSubtask(subtask);

        name = "сабтаск2";
        description = "описание_сабтаск2";
        Subtask subtask2 = new Subtask(name,description,epicId);
        manager.createSubtask(subtask2);

        name = "сабтаск3";
        description = "описание_сабтаск3";
        epicId = epic2.getUid();
        Subtask subtask3 = new Subtask(name,description,epicId);
        manager.createSubtask(subtask3);

        System.out.println(manager.listOfSubtask.get(subtask.getUid()).getUid() + " "
                + manager.listOfSubtask.get(subtask.getUid()).getName() + " "
                + manager.listOfSubtask.get(subtask.getUid()).getDescription() + " "
                + manager.listOfSubtask.get(subtask.getUid()).getStatus()
                + manager.listOfSubtask.get(subtask.getUid()).getEpicID());

        System.out.println(manager.listOfSubtask.get(subtask2.getUid()).getUid() + " "
                + manager.listOfSubtask.get(subtask2.getUid()).getName() + " "
                + manager.listOfSubtask.get(subtask2.getUid()).getDescription() + " "
                + manager.listOfSubtask.get(subtask2.getUid()).getStatus()
                + manager.listOfSubtask.get(subtask2.getUid()).getEpicID());

        System.out.println(manager.listOfSubtask.get(subtask3.getUid()).getUid() + " "
                + manager.listOfSubtask.get(subtask3.getUid()).getName() + " "
                + manager.listOfSubtask.get(subtask3.getUid()).getDescription() + " "
                + manager.listOfSubtask.get(subtask3.getUid()).getStatus()
                + manager.listOfSubtask.get(subtask3.getUid()).getEpicID());


        System.out.println();
        System.out.println("снова про эпик");
        System.out.println(manager.listOfEpic.get(epic.getUid()).getUid() + " "
                + manager.listOfEpic.get(epic.getUid()).getName() + " "
                + manager.listOfEpic.get(epic.getUid()).getDescription() + " "
                + manager.listOfEpic.get(epic.getUid()).getStatus() + " "
                + !manager.listOfEpic.get(epic.getUid()).subtasksIds.isEmpty());

        System.out.println();
        System.out.println("все таски" + manager.getAllTasc());

        System.out.println();
        System.out.println("все эпики'" + manager.getAllEpic());

        System.out.println();
        System.out.println("все сабтаски" + manager.getAllSubtasc());

        System.out.println();
        System.out.println("таск2 - " + manager.getTaskById(2).getName());

        System.out.println();
        System.out.println("эпик1 - " + manager.getEpicById(3).getName());

        System.out.println();
        System.out.println("сабтаск3 - " + manager.getSubtaskById(7).getName());

        System.out.println("сабтаски эпика3" + manager.getAllSubtasksByEpicId(3));

        name = "новый_сабтаск3";
        description = "Новый_описание_сабтаск3";
        epicId = epic2.getUid();
        Subtask newSub3 = new Subtask(name,description,epicId);
        newSub3.setStatus("DONE");
        newSub3.setUid(7);
        manager.updateSubtask(newSub3);
        System.out.println(manager.listOfSubtask.get(subtask3.getUid()).getUid() + " "
                + manager.listOfSubtask.get(subtask3.getUid()).getName() + " "
                + manager.listOfSubtask.get(subtask3.getUid()).getDescription() + " "
                + manager.listOfSubtask.get(subtask3.getUid()).getStatus()
                + manager.listOfSubtask.get(subtask3.getUid()).getEpicID());


        name = "новый_эпик2";
        description = "Новый_описание_эпика2";
        Epic newEpic2 = new Epic(name,description);
        newEpic2.setUid(4);
        manager.updateEpic(newEpic2);
        System.out.println(manager.listOfEpic.get(epic2.getUid()).getUid() + " "
                + manager.listOfEpic.get(epic2.getUid()).getName() + " "
                + manager.listOfEpic.get(epic2.getUid()).getDescription() + " "
                + manager.listOfEpic.get(epic2.getUid()).getStatus() + " "
                + !manager.listOfEpic.get(epic2.getUid()).subtasksIds.isEmpty());

        name = "новый_таск2";
        description = "Новый_описание_таски2";
        Task newTask2 = new Task(name,description);
        newTask2.setUid(2);
        manager.updateTask(newTask2);
        System.out.println(manager.listOfTask.get(task2.getUid()).getUid() + " "
                + manager.listOfTask.get(task2.getUid()).getName() + " "
                + manager.listOfTask.get(task2.getUid()).getDescription() + " "
                + manager.listOfTask.get(task2.getUid()).getStatus());


        manager.deleteSubtaskById(7);
        manager.deleteEpicById(3);
        manager.deleteTaskById(1);
        System.out.println();
        System.out.println("delID1 все таски" + manager.getAllTasc());
        System.out.println();
        System.out.println("delID3 все эпики'" + manager.getAllEpic());
        System.out.println();
        System.out.println("delID7 все сабтаски" + manager.getAllSubtasc());




        Boolean isTasc = manager.clearAllTasc();
        System.out.println();
        System.out.println("все таски удалены" + manager.getAllTasc());

        Boolean isEpic = manager.clearAllEpic();
        System.out.println();
        System.out.println("все эпики удалены" + manager.getAllEpic());

        Boolean isSubtasc = manager.clearAllSubtasc();
        System.out.println();
        System.out.println("все сабтаски удалены" + manager.getAllSubtasc());

    }
}
