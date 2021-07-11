package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    //TODO: Read csv and generate emp to data mapping and return a list
    public List<EmployeeDetailsDTO> getEmployeeDetailList() {
        EmployeeDetailsDTO employee1 = new EmployeeDetailsDTO("emp1", "DEV", "manager1",20,2,1);
        EmployeeDetailsDTO employee2 = new EmployeeDetailsDTO("emp2", "DEV", "manager1",10,2,1);
        EmployeeDetailsDTO employee3 = new EmployeeDetailsDTO("emp3", "QA", "manager2",10,2,1);
        EmployeeDetailsDTO employee4 = new EmployeeDetailsDTO("emp4", "DEV", "manager2",12,2,1);
        EmployeeDetailsDTO employee5 = new EmployeeDetailsDTO("emp5", "DEV", "manager3",10,2,1);
       List<EmployeeDetailsDTO> employeeList = List.of(employee1,
               employee2,
               employee3,
               employee4,
               employee5);
        return employeeList;
    }

    public int calculateScore(String role, int feature, int bug, int prod) {
        //Common constants
        int devFeature=10;
        int devBug=-5;
        int devProd=0;
        int qaFeature=5;
        int qaBug=10;
        int qaProd=-10;

        switch(role.toUpperCase()){
            case "DEV": return ((feature*devFeature)+(bug*devBug)+(prod*devProd));
            case "QA": return ((feature*qaFeature)+(bug*qaBug)+(prod*qaProd));
        }
        return 0;
    }

    public Response getBestPerformers(List<EmployeeDetailsDTO> employeeDetailsDTOS) {
        Main main=new Main();

        //constants
        String dev="DEV";
        String qa="QA";

        //Contains list of managers and their score based on QA and Devs associated with them
        HashMap<String, Integer> manager=new HashMap<>();

        //TODO: Create a POJO to store dev score and name
        int maxDevScore=Integer.MIN_VALUE;
        String maxDevName="NA";
        int maxQAScore=Integer.MIN_VALUE;
        String maxQAName="NA";

        //Iterate over employee list and find max performers
        for(EmployeeDetailsDTO employeeDetailsDTO: employeeDetailsDTOS){
            String role= employeeDetailsDTO.getEngineerRole();
            int feature =employeeDetailsDTO.getFeaturePoint();
            int bug =employeeDetailsDTO.getUatBugPoint();
            int prod =employeeDetailsDTO.getProdBugPoint();
            int score= main.calculateScore(role,feature, bug, prod);

            if(dev.equalsIgnoreCase(role)){
                if(maxDevScore<score){
                    maxDevName=employeeDetailsDTO.getEngineerName();
                    maxDevScore=score;
                }
            }
            if(qa.equalsIgnoreCase(role)){
                if(maxQAScore<score){
                    maxQAName=employeeDetailsDTO.getEngineerName();
                    maxQAScore=score;
                }
            }

            if(manager.containsKey(employeeDetailsDTO.getManager())){
                int lastScore= manager.get(employeeDetailsDTO.getManager());
                manager.put(employeeDetailsDTO.getManager(), lastScore+score);
            } else {
                manager.put(employeeDetailsDTO.getManager(), score);
            }
        }
        String maxManager="NA";
        int managerMaxScore=Integer.MIN_VALUE;

        //Iterate over manager hashmap to find the manager with greatest value
        for (Map.Entry<String,Integer> entry : manager.entrySet()){
            int curScore=entry.getValue();
            if(curScore>managerMaxScore){
                managerMaxScore=curScore;
                maxManager=entry.getKey();
            }
        }

        Response response = new Response(maxDevName, maxQAName, maxManager);
        return response;
    }

    public static void main(String[] args) {
	    Main main=new Main();

	    List<EmployeeDetailsDTO> employeeList = main.getEmployeeDetailList();
        Response res= main.getBestPerformers(employeeList);
        System.out.println("Best developer: "+res.getDev());
        System.out.println("Best QA: "+res.getQa());
        System.out.println("Best manager: "+res.getManager());
    }
}

