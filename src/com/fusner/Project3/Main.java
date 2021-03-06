package com.fusner.Project3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

    static Scanner scanner = new Scanner(System.in);
    static ToDoList<Item> list = new ToDoList<>();

    public static void main(String[] args)
    {

        Boolean isInputCorrect = true;
        int choice = -1;
        scanner.useDelimiter("\\n");
        displayMenu();

        try
        {
            choice = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            isInputCorrect = false;
        }

        while (choice != 0)
        {
            if (isInputCorrect)
            {
                switch (choice)
                {
                    case 1:
                        add();
                        break;
                    case 2:
                        displayByPriority();
                        break;
                    case 3:
                        displayAll();
                        break;
                }
            }
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            displayMenu();
            try
            {
                choice = scanner.nextInt();
                isInputCorrect = true;
            }
            catch (InputMismatchException e)
            {
                isInputCorrect = false;
            }
        }
    }

    static public void add()
    {

        System.out.println("\nEnter a title:");
        String title = scanner.next();

        System.out.println("\nEnter a description:");
        String description = scanner.next();

        boolean isInputCorrect = false;
        int priority = 0;
        while (!isInputCorrect)
        {
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            try
            {
                System.out.println("\nEnter the priority (0-5):");
                priority = scanner.nextInt();
                isInputCorrect = true;
            }
            catch (InputMismatchException e)
            {
                isInputCorrect = false;
            }
        }


        list.add(new Item(title, description, priority));
    }

    static public void displayAll()
    {
        System.out.println("\nTo-Do:");

        ToDoList<Item> sortedList = sort(list);

        for (int i = 0; i < sortedList.size(); i++)
        {
            System.out.println("(" + sortedList.get(i).getPriority() + ") " + sortedList.get(i).getTitle());
        }


        System.out.println();
    }

    static public void displayByPriority()
    {
        boolean isInputCorrect = false;
        int priority = 0;
        while (!isInputCorrect)
        {
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            try
            {
                System.out.println("\nEnter the priority:");
                priority = scanner.nextInt();
                isInputCorrect = true;
            }
            catch (InputMismatchException e)
            {
                isInputCorrect = false;
            }
        }

        if (priority > 5)
        {
            priority = 5;
        }
        else if (priority < 0)
        {
            priority = 0;
        }

        ToDoList<Item> sortedList = sort(list);

        System.out.println("\nTo-Do:");
        for (int i = 0; i < sortedList.size(); i++)
        {
            if (sortedList.get(i).getPriority() == priority)
            {
                sortedList.get(i).display();
            }
        }
        System.out.println();
    }

    static void displayMenu()
    {
        System.out.println("(1) Add an item.\n(2) List task by priority.\n(3) List all tasks.\n(0) Exit.\nPlease choose an option:");
    }

    static ToDoList<Item> sort(ToDoList<Item> list)
    {
        ToDoList<Item> oldList = new ToDoList<>();
        for (int i = 0; i < list.size(); i++)
        {
            oldList.add(list.get(i));
        }
        ToDoList<Item> newList = new ToDoList<>();
        while (oldList.size() > 0)
        {
            Item highest = oldList.get(0);
            int index = 0;
            for (int i = 0; i < oldList.size(); i++)
            {
                if (oldList.get(i).compareTo(highest) > 0)
                {
                    highest = oldList.get(i);
                    index = i;
                }
            }
            newList.add(highest);
            oldList.remove(index);
        }
        return newList;
    }
}
