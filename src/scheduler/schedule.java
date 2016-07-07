package scheduler;

import beans.Section;
import beans.Course;
import beans.Degree;
import beans.DegreePlanReqs;
import beans.DegreeReqs;
import beans.Faculty;
import beans.Section;
import beans.Semester;
import beans.Student;
import beans.StudentCourse;
import java.util.*;
import java.io.File;
import java.util.Scanner;

import controller.MainController;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.lang.ArrayUtils;
import registers.CourseRegister;
import registers.DegreePlanReqsRegister;
import registers.DegreeRegister;
import registers.DegreeReqsRegister;
import registers.FacultyRegister;
import registers.SemesterRegister;
import registers.StudentCourseRegister;
import registers.StudentRegister;
import schedule.generateschedule;



//main class
public class schedule {
    
        public  static Section[] sectionArray;
       static Section[] secArray;
    
    
	
	static int noclass,nocourse,noins,nostgrp;
	static double[] fit;
	
	

	
	
	public static void main(String[] args)
	{
                String semesterSelected=generateschedule.semesterSelected;
                String sectionFillperc=generateschedule.sectionFillperc;
                String sectionOveragePerc=generateschedule.sectionOveragePerc;
                String iterations=generateschedule.iterations;
                
                String sem = semesterSelected.substring(semesterSelected.length()-2);
				
                HashMap<String, Integer> coursesOffered= new HashMap();
                HashMap<String, String[]> coursesFaculty= new HashMap();
                HashMap<String, String> facultyAvailable= new HashMap();
                HashMap<String, Integer> facultyLoad= new HashMap(); 
				
		ArrayList<Course> courseList=CourseRegister.courses;	
                ArrayList<Faculty> facultyList=FacultyRegister.faculties;
                ArrayList<Student> studentList=StudentRegister.students;
                ArrayList<Degree> degreeList=DegreeRegister.degrees;
                ArrayList<DegreePlanReqs> degreePlanList=DegreePlanReqsRegister.degreePlanReqs;
                
				if("FA".equalsIgnoreCase(sem)){
					
					for(Course course:courseList){
						if("Y".equalsIgnoreCase(course.getOfferedFA())){
							coursesOffered.put(course.getCode(), 0);
							coursesFaculty.put(course.getCode(), course.getTeachers().split(","));
						}
					}
					System.out.println(courseList.size());
					for(Faculty faculty:facultyList){
						if(!"0".equalsIgnoreCase(faculty.getMaxLoadFA())){
							facultyAvailable.put(faculty.getLname(), faculty.getDays());
							facultyLoad.put(faculty.getLname(), Integer.parseInt(faculty.getMaxLoadFA()));
						}
					}
				} else if ("SU".equalsIgnoreCase(sem)){
					for(Course course:courseList){
						if("Y".equalsIgnoreCase(course.getOfferedSU())){
							coursesOffered.put(course.getCode(), 0);
							coursesFaculty.put(course.getCode(), course.getTeachers().split(","));
						}
					}
					for(Faculty faculty:facultyList){
						if(!"0".equalsIgnoreCase(faculty.getMaxLoadSU())){
							facultyAvailable.put(faculty.getLname(), faculty.getDays());
							facultyLoad.put(faculty.getLname(), Integer.parseInt(faculty.getMaxLoadSU()));
						}
					}
				} else if ("SP".equalsIgnoreCase(sem)){
					for(Course course:courseList){
						if("Y".equalsIgnoreCase(course.getOfferedSP())){
							coursesOffered.put(course.getCode(), 0);
							coursesFaculty.put(course.getCode(), course.getTeachers().split(","));
						}
					}
					for(Faculty faculty:facultyList){
						if(!"0".equalsIgnoreCase(faculty.getMaxLoadSP())){
							facultyAvailable.put(faculty.getLname(), faculty.getDays());
							facultyLoad.put(faculty.getLname(), Integer.parseInt(faculty.getMaxLoadSP()));
						}
					}
				}
				
				Set SOK3 = coursesFaculty.keySet();
				Iterator iterator3 = SOK3.iterator();
				HashMap<String, Integer> courseCountFaculty = new HashMap();
				System.out.println("AVAILABLE COURSES FOR THE SEM "+semesterSelected+" ARE:courseFaculty");
                                sectionArray=null;
				while (iterator3.hasNext()){
					String crs1 = (String) iterator3.next();
					String[] facultyRequired = (String[]) coursesFaculty.get(crs1);
					for(int i=0;i<facultyRequired.length;i++){
						System.out.println("Course: "+crs1+"\tFaculty: "+facultyRequired[i]+"\t\tMaxLoad: "+facultyLoad.get(facultyRequired[i]));
						int value = 0;
						if(courseCountFaculty.get(crs1)!=null){
							value = courseCountFaculty.get(crs1);;
						}
						courseCountFaculty.put(crs1, value+1);
						
						if(facultyLoad.get(facultyRequired[i])!=null){
							if(sectionArray!=null){
								Section[] secArray = new Section[sectionArray.length+1];
								for(int j=0;j<sectionArray.length;j++){
									secArray[j]=sectionArray[j];
								}
								Section sec = new Section();
								sec.setSectionNumber(Integer.toString(secArray.length));
								sec.setCourse(crs1);
								sec.setFaculty(facultyRequired[i]);
								sec.setDays(facultyAvailable.get(facultyRequired[i]));
								sec.setSemester(semesterSelected);
								
								secArray[sectionArray.length] = sec;
								sectionArray = secArray;
							}else{
								Section sec = new Section();
								sec.setSectionNumber("1");
								sec.setCourse(crs1);
								sec.setFaculty(facultyRequired[i]);
								sec.setDays(facultyAvailable.get(facultyRequired[i]));
								sec.setSemester(semesterSelected);
								
								sectionArray = new Section[1];
								sectionArray[0] = sec;
							}
						}						
					}
				}
				
				
				System.out.println("COURSES WITH AVAILABLE FACULTY FOR THE SEM "+
									semesterSelected+" ARE:sectionArray");
				for(int j=0;j<sectionArray.length;j++){
					System.out.println("Section: "+sectionArray[j].getSectionNumber()+
							"\tCourse: "+sectionArray[j].getCourse()+
							"\tFaculty: "+sectionArray[j].getFaculty()+
							"\t\tDays: "+sectionArray[j].getDays());
				}
				GA(args, courseList, facultyList, studentList, degreeList, degreePlanList, sectionArray, 
						sectionFillperc, facultyLoad, sectionOveragePerc, semesterSelected, iterations);
				//dispose();
				
			
			}

        
        public static void GA(String[] args, ArrayList<Course> crsArr, ArrayList<Faculty> facArr, final ArrayList<Student> studArr, final ArrayList<Degree> degArr, final ArrayList<DegreePlanReqs> degPlanArr, 
			final Section[] sectionArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester, String iterations) {
		
	Population pop = new Population(studArr.toArray(new Student[studArr.size()]), degArr.toArray(new Degree[degArr.size()]), 
                                        degPlanArr.toArray(new DegreePlanReqs[degPlanArr.size()]), sectionArray, 
                                        minFillPercent, facultyLoad, maxOverage, semester, iterations); 
        Individual[] newPop = new Individual[Population.POP_SIZE];
        Individual[] indiv = new Individual[2];

       
        // main loop
        int count;
        for (int iter = 0; iter < Population.MAX_ITER; iter++) {
            count = 0;

            // Elitism
            for (int i = 0; i < Population.ELITISM_K; ++i) {
                newPop[count] = pop.findBestIndividual();
                count++;
            }

            // build new Population
            while (count < Population.POP_SIZE) {
                // Selection
                indiv[0] = pop.rouletteWheelSelection();
                indiv[1] = pop.rouletteWheelSelection();

                // Crossover
                if (Population.m_rand.nextDouble() < Population.CROSSOVER_RATE) {
                    indiv = Population.onePoinCrossover(indiv[0], indiv[1]);
                }

                // Mutation
                if (Population.m_rand.nextDouble() < Population.MUTATION_RATE) {
                    indiv[0].mutate();
                }
                if (Population.m_rand.nextDouble() < Population.MUTATION_RATE) {
                    indiv[1].mutate();
                }

                // add to new population
                newPop[count] = indiv[0];
                newPop[count + 1] = indiv[1];
                count += 2;
            }
            pop.setPopulation(newPop);
            //System.gc();
            // reevaluate current population
            pop.evaluate(studArr.toArray(new Student[studArr.size()]), degArr.toArray(new Degree[degArr.size()]),
                           degPlanArr.toArray(new DegreePlanReqs[degPlanArr.size()]), 
                                   sectionArray, minFillPercent, facultyLoad, maxOverage, semester);
//            System.out.print(iter+"\tTotal Fitness = " + pop.totalFitness);
//            System.out.println(" ; Best Fitness = "
//                    + pop.findBestIndividual().getFitnessValue());
        }

        // best indiv
        Individual bestIndiv = pop.findBestIndividual();
        
//        System.out.println("Best Individual Fitness = "
//                    + bestIndiv.getFitnessValue());
        
        int[] bestGene = bestIndiv.getGenes();
        schedule.secArray = sectionArray;
        
        HashMap<String, Integer> numberOfStudents = numberOfStudents(bestGene, studArr.toArray(new Student[studArr.size()]), degArr.toArray(new Degree[degArr.size()]),
                           degPlanArr.toArray(new DegreePlanReqs[degPlanArr.size()]), sectionArray, minFillPercent, facultyLoad, maxOverage, semester);
        
        
		
        
       System.out.println("\n\n SCHEDULE FOR THE SEMESTER "+semester+" SHALL HAVE FOLLOWING COURSES:");
        for(int i=0;i<bestGene.length;i++){
        	if(bestGene[i]==1){
        		Section sec = sectionArray[i];
        		System.out.println("Course: "+sec.getCourse()+"\tDays: "+sec.getDays()+"\tFaculty: "+sec.getFaculty()+"\tStudents: "+numberOfStudents.get(sec.getCourse()));
        	}
        }
        
        int countBestGene = 0;
		for(int i=0;i<bestGene.length;i++){
			countBestGene = countBestGene + bestGene[i];
		}
		
		Section[] secArray = new Section[countBestGene];
		int j=0;
		for(int i=0;i<sectionArray.length;i++){
			if(bestGene[i]==1){
				secArray[j] = sectionArray[i];
				j++;
			}
		}
		
		int[][] sectionDayMapping = new int[secArray.length][4];
		for (int i=0;i<secArray.length;i++){
			if(secArray[i].getDays().contains("M")){
				sectionDayMapping[i][0]=1;
			}
			if(secArray[i].getDays().contains("T")){
				sectionDayMapping[i][1]=1;
			}
			if(secArray[i].getDays().contains("W")){
				sectionDayMapping[i][2]=1;
			}
			if(secArray[i].getDays().contains("R")){
				sectionDayMapping[i][3]=1;
			}
		}
		
		//System.out.println("sectionDayMapping");
		for(int i=0;i<secArray.length;i++){
			//System.out.print("\n");
			for(int k=0;k<4;k++){
				//System.out.print("\t"+sectionDayMapping[i][k]);
			}
		}
		//System.out.print("\n");
		
		int[] sectionDayCount = new int[secArray.length];
		for(int i=0;i<secArray.length;i++){
			for(int k=0;k<4;k++){
				//if(i==0)sectionDayCount[0]=sectionDayMapping[0][k];
				sectionDayCount[i] = sectionDayCount[i]+sectionDayMapping[i][k];
			}
		}
		
		//System.out.println("sectionDayCount");
		//System.out.print("\n");
		for(int i=0;i<secArray.length;i++){
			//System.out.print(sectionDayCount[i]+"  ");
		}
		//System.out.print("\n");
		
		int[] daySectionCount = new int[4];
		
		int[][] FinalSectionDayMapping = new int[secArray.length][4];
		for(int i=0;i<sectionDayCount.length;i++){
			if(sectionDayCount[i]==1){
				for(int k=0;k<4;k++){
					if(sectionDayMapping[i][k]==1){
						FinalSectionDayMapping[i][k]=1;
						daySectionCount[k] = daySectionCount[k] + 1;
					}
				}
				
			}
		}
		for(int i=0;i<sectionDayCount.length;i++){
			if(sectionDayCount[i]==2){
				int large = 999999;
				int min = 0;
				for(int k=0;k<4;k++){
					if(sectionDayMapping[i][k]==1){
						if(daySectionCount[k]<large){
							min = k;
							large = daySectionCount[k];
						}
					}
				}
				FinalSectionDayMapping[i][min]=1;
				daySectionCount[min] = daySectionCount[min] + 1;
				
			}
		}
		for(int i=0;i<sectionDayCount.length;i++){
			if(sectionDayCount[i]==3){
				int large = 999999;
				int min = 0;
				for(int k=0;k<4;k++){
					if(sectionDayMapping[i][k]==1){
						if(daySectionCount[k]<large){
							min = k;
							large = daySectionCount[k];
						}
					}
				}
				FinalSectionDayMapping[i][min]=1;
				daySectionCount[min] = daySectionCount[min] + 1;
				
			}
		}
		for(int i=0;i<sectionDayCount.length;i++){
			if(sectionDayCount[i]==4){
				int large = 999999;
				int min = 0;
				for(int k=0;k<4;k++){
					if(sectionDayMapping[i][k]==1){
						if(daySectionCount[k]<large){
							min = k;
							large = daySectionCount[k];
						}
					}
				}
				FinalSectionDayMapping[i][min]=1;
				daySectionCount[min] = daySectionCount[min] + 1;
				
			}
		}
		
		
		for(int i=0;i<secArray.length;i++){
			for(int k=0;k<4;k++){
				if(FinalSectionDayMapping[i][k]==1){
					if(k==0)secArray[i].setDays("M");
					else if(k==1)secArray[i].setDays("T");
					else if(k==2)secArray[i].setDays("W");
					else if(k==3)secArray[i].setDays("R");
				}
			}
		}
		
		//System.out.print("\n");
		//System.out.print("daySectionCount");
		//System.out.print("\n");
		for(int i=0;i<4;i++){
			//System.out.print(daySectionCount[i]+"  ");
		}
		//System.out.print("\n");
		
		//System.out.print("secArray");
		//System.out.print("\n");
		for(int i=0;i<secArray.length;i++){
			//System.out.println(secArray[i].getDays());
		}
		//System.out.print("\n");
		
        new printtable(args, crsArr.toArray(new Course[crsArr.size()]), facArr.toArray(new Faculty[facArr.size()]),
                                            studArr.toArray(new Student[studArr.size()]), degArr.toArray(new Degree[degArr.size()]), 
                                            degPlanArr.toArray(new DegreePlanReqs[degPlanArr.size()]), minFillPercent, 
                                            facultyLoad, maxOverage, semester,secArray, numberOfStudents, bestGene).printData();
        
//		new printtable(args, crsArr, facArr, studArr, degArr, degPlanArr, minFillPercent, 
//        		facultyLoad, maxOverage, semester,secArray, numberOfStudents, bestGene);
		
        //return sectionArray;
        		
	}
	
	
	public static HashMap<String, Integer> numberOfStudents(int[] genes, Student[] studArr, Degree[] degArr, DegreePlanReqs[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester){
        
    	int objectiveValue = 0;
    	HashMap<String, Integer> courseStudent = new HashMap();
     	
    	for(int i=0;i<studArr.length;i++){ 
    		Student student = studArr[i];
    		String degreeCode = student.getDegreePlan(); 
    		String[] coursesApplied = student.getCourseNum(); 
    		String[] gradesReceived = student.getGrade();
    		DegreePlanReqs degreePlan = new DegreePlanReqs(); 
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ 
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStandard = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); 
    				String[] coursesToApplyStud = coursesToApplyStandard; 
    				int creditsToEarn = Integer.parseInt(degreePlan.getHours()); 
    				
    				if(coursesApplied != null){
    					for(int k=0;k<coursesApplied.length;k++){ 
        					for(int l=0;l<coursesToApplyStandard.length;l++){ 
        						if(coursesApplied[k].equals(coursesToApplyStandard[l])){ 
        							if(creditsToEarn > 0){ 
        								if("A".equalsIgnoreCase(gradesReceived[k])
        										|| "B".equalsIgnoreCase(gradesReceived[k])
        										|| "C".equalsIgnoreCase(gradesReceived[k])
        										|| "D".equalsIgnoreCase(gradesReceived[k])
        										|| "CIP".equalsIgnoreCase(gradesReceived[k])){
        									
        									ArrayUtils.removeElement(coursesToApplyStud, coursesToApplyStandard[l]);
        									creditsToEarn = creditsToEarn - 3;
        								}
        							} else { 
        								coursesToApplyStud = new String[0];
        							}
        						}
        					}
        				}
    				}
   				for(int m=0;m<genes.length;m++){ 
    					if(genes[m] == 1){
    						Section section = secArray[m];
    						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){ 
    							objectiveValue++;
    							if(courseStudent.containsKey(section.getCourse())){
    								int number = courseStudent.get(section.getCourse());
    								courseStudent.put(section.getCourse(), number+1);
    							}else{
    								courseStudent.put(section.getCourse(), 1);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	for(int i=1;i<degArr.length;i++){
    		
    		String degreeCode = degArr[i].getCode();
    		int numberOfStudents = Integer.parseInt(degArr[i].getForecast());
    		
    		DegreePlanReqs degreePlan = new DegreePlanReqs(null,null,null,null,null);
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ 
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStud  = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); // Standard List of Courses which the student needs to Pass.
    				
    				for(int m=0;m<genes.length;m++){ 
    					if(genes[m] == 1){ 
    						Section section = secArray[m];
    						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){
    							objectiveValue = objectiveValue+numberOfStudents;
    							if(courseStudent.containsKey(section.getCourse())){
    								int number = courseStudent.get(section.getCourse());
    								courseStudent.put(section.getCourse(), number+numberOfStudents);
    							}else{
    								courseStudent.put(section.getCourse(), numberOfStudents);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	return courseStudent;
    	
    }


}

class Individual {
	
	public static int SIZE = 10000;
    private int[] genes = new int[SIZE];
    private double fitnessValue;
    private HashMap<String, Integer> numberOfStudent;
    
    
	public HashMap<String, Integer> getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(HashMap<String, Integer> numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}

	public Individual(Section[] secArray) {
        Individual.SIZE = secArray.length;
        this.setSIZE(secArray.length);
    }
    
    public Individual() {}
    
    public static int getSIZE() {
        return SIZE;
    }

    public static void setSIZE(int SIZE) {
        Individual.SIZE = SIZE;
    }
    
    public double getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(double fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int gene) {
        this.genes[index] = gene;
    }

    public void randGenes() {
        Random rand = new Random();
        for(int i=0; i<SIZE; ++i) {
            this.setGene(i, rand.nextInt(2));
        }
    }

    public void mutate() {
        Random rand = new Random();
        int index = rand.nextInt(SIZE);
        this.setGene(index, 1-this.getGene(index));    // flip
    }

    public double evaluate(Student[] studArr, Degree[] degArr, DegreePlanReqs[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester) {
        this.setFitnessValue(objectiveFunction(this.genes, studArr, degArr, degPlanArr, secArray, minFillPercent, facultyLoad, maxOverage, semester));
        return this.fitnessValue;
    }
    
    public double objectiveFunction(int[] genes, Student[] studArr, Degree[] degArr, DegreePlanReqs[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester){
        
    	int objectiveValue = 0;
    	int facultyLoadExceedPenalty = 0;
    	int numberOfCoursesPenalty = 0;
    	int maxStudentCountPenalty = 0;
    	HashMap<String, Integer> courseStudent = new HashMap();
    	
    	
    	for(int i=0;i<studArr.length;i++){ 
    		Student student = studArr[i];
    		String degreeCode = student.getDegreePlan(); 
    		String[] coursesApplied = student.getCourseNum(); 
    		String[] gradesReceived = student.getGrade(); 
    		
    		DegreePlanReqs degreePlan = new DegreePlanReqs(); // 
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ 
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStandard = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(",");
    				String[] coursesToApplyStud = coursesToApplyStandard;
    				int creditsToEarn = Integer.parseInt(degreePlan.getHours()); 
    				
    				if(coursesApplied != null){
    					for(int k=0;k<coursesApplied.length;k++){ 
        					for(int l=0;l<coursesToApplyStandard.length;l++){ 
        						if(coursesApplied[k].equals(coursesToApplyStandard[l])){ 
        							if(creditsToEarn > 0){ 
        								if("A".equalsIgnoreCase(gradesReceived[k])
        										|| "B".equalsIgnoreCase(gradesReceived[k])
        										|| "C".equalsIgnoreCase(gradesReceived[k])
        										|| "D".equalsIgnoreCase(gradesReceived[k])
        										|| "CIP".equalsIgnoreCase(gradesReceived[k])){
        									
        									ArrayUtils.removeElement(coursesToApplyStud, coursesToApplyStandard[l]);
        									creditsToEarn = creditsToEarn - 3;
        								}
        							} else { 
        								coursesToApplyStud = new String[0];
        							}
        						}
        					}
        				}
    				}
    				
    				
    				for(int m=0;m<genes.length;m++){ 
    					if(genes[m] == 1){ 
    						Section section = secArray[m];
    						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){ 
    							objectiveValue++;
    							if(courseStudent.containsKey(section.getCourse())){
    								int number = courseStudent.get(section.getCourse());
    								courseStudent.put(section.getCourse(), number+1);
    							}else{
    								courseStudent.put(section.getCourse(), 1);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	// Now for the students who are newly expected to be joining the university.
    	for(int i=1;i<degArr.length;i++){
    		
    		String degreeCode = degArr[i].getCode();
    		int numberOfStudents = Integer.parseInt(degArr[i].getForecast());
    		
    		DegreePlanReqs degreePlan = new DegreePlanReqs(null,null,null,null,null);
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ // Checking which degree plan student belongs to
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStud  = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); // Standard List of Courses which the student needs to Pass.
    			
    				for(int m=0;m<genes.length;m++){ 
    					if(genes[m] == 1){ 
    						Section section = secArray[m];
    						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){
    							objectiveValue = objectiveValue+numberOfStudents;
    							if(courseStudent.containsKey(section.getCourse())){
    								int number = courseStudent.get(section.getCourse());
    								courseStudent.put(section.getCourse(), number+numberOfStudents);
    							}else{
    								courseStudent.put(section.getCourse(), numberOfStudents);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    
    	
    	int count = 0;
    	for(int i=0;i<genes.length;i++){
    		if(genes[i]==1)count++;
    	}
    	numberOfCoursesPenalty = count * ((Integer.parseInt(minFillPercent)*25)/100);
    	
    	// Now adding penalty for unsatisfied Faculty.
    	Set SOK = facultyLoad.keySet();
		Iterator iterator = SOK.iterator();
		while(iterator.hasNext()){
			String fac = (String) iterator.next();
			int maxLoad = (int) facultyLoad.get(fac);
			int load = 0;
			
			for(int j=0;j<genes.length;j++){
    			if(genes[j]==1){
    				Section sec = secArray[j];
    				if(fac.equalsIgnoreCase(sec.getFaculty())){
    					load = load+3;
    				}
    					
    			}
    		}
    		
    		if(load>maxLoad){
    			//System.out.println(facultyLoadExceedPenalty);
    			facultyLoadExceedPenalty = facultyLoadExceedPenalty + 10000000;
    		}
		}
		
    	
    	/*for(int i=1;i<facArr.length;i++){
    		Faculty fac = facArr[i];
    		int load = 0;
    		System.out.println(facultyLoad);
    		System.out.println(facultyLoad.size());
    		System.out.println(fac.getLastname());
    		int maxLoad = facultyLoad.get(fac.getLastname());
    		
    	}*/
		
		Set SOK1 = courseStudent.keySet();
		Iterator iterator1 = SOK1.iterator();
		while(iterator1.hasNext()){
			String course = (String) iterator1.next();
			int cnt = (int) courseStudent.get(course);

			if(cnt>25*(1+(Integer.parseInt(maxOverage)/100))){
				maxStudentCountPenalty = cnt * 10;
			}
		}
		
    	int fitness = (objectiveValue - numberOfCoursesPenalty - facultyLoadExceedPenalty-maxStudentCountPenalty);
    	
    	if(fitness<0)return 0;
    	else return fitness;
    }
    
}

class Population {
	
	public final static int ELITISM_K = 5;
	public final static int POP_SIZE = 100 + ELITISM_K;  
	public static int MAX_ITER = 10;        
	public final static double MUTATION_RATE = 0.1;     
	public final static double CROSSOVER_RATE = 0.8;     

    public static Random m_rand = new Random();  
    private Individual[] m_population;
    public double totalFitness;

    public Population(Student[] studArr, Degree[] degArr, DegreePlanReqs[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester, String iterations) {
        m_population = new Individual[POP_SIZE];
        MAX_ITER = Integer.parseInt(iterations);

        for (int i = 0; i < POP_SIZE; i++) {
            m_population[i] = new Individual(secArray);
            m_population[i].randGenes();
        }

        // evaluate current population
        this.evaluate(studArr, degArr, degPlanArr, secArray, minFillPercent, facultyLoad, maxOverage, semester);
    }

    public void setPopulation(Individual[] newPop) {
        System.arraycopy(newPop, 0, this.m_population, 0, POP_SIZE); // Replaces the newPop with the existing population
    }

    public Individual[] getPopulation() {
        return this.m_population;
    }

    public double evaluate(Student[] studArr, Degree[] degArr, DegreePlanReqs[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester) {
        this.totalFitness = 0.0;
        for (int i = 0; i < POP_SIZE; i++) {
            this.totalFitness += m_population[i].evaluate(studArr, degArr, degPlanArr, secArray, minFillPercent, facultyLoad, maxOverage, semester);
        }
        return this.totalFitness;
    }

    public Individual rouletteWheelSelection() {
        double randNum = m_rand.nextDouble() * this.totalFitness;
        int idx;
        for (idx=0; idx<POP_SIZE && randNum>0; idx++) {
            randNum -= m_population[idx].getFitnessValue();
        }
        return m_population[idx-1];
    }

    public Individual findBestIndividual() {
        int idxMax = 0, idxMin = 0;
        double currentMax = 0.0;
        double currentMin = 1.0;
        double currentVal;

        for (int idx=0; idx<POP_SIZE; ++idx) {
            currentVal = m_population[idx].getFitnessValue();
            if (currentMax < currentMin) {
                currentMax = currentMin = currentVal;
                idxMax = idxMin = idx;
            }
            if (currentVal > currentMax) {
                currentMax = currentVal;
                idxMax = idx;
            }
            if (currentVal < currentMin) {
                currentMin = currentVal;
                idxMin = idx;
            }
        }

      
        return m_population[idxMax];       
    }

    
    public static Individual[] onePoinCrossover(Individual indiv1,Individual indiv2) {
        Individual[] newIndiv = new Individual[2];
        newIndiv[0] = new Individual();
        newIndiv[1] = new Individual();

        int randPoint = m_rand.nextInt(Individual.SIZE);
        int i;
        for (i=0; i<randPoint; ++i) {
            newIndiv[0].setGene(i, indiv1.getGene(i));
            newIndiv[1].setGene(i, indiv2.getGene(i));
        }
        for (; i<Individual.SIZE; ++i) {
            newIndiv[0].setGene(i, indiv2.getGene(i));
            newIndiv[1].setGene(i, indiv1.getGene(i));
        }
        return newIndiv;
    }
    
    
    public static Individual[] uniformCrossover(Individual indiv1,Individual indiv2){
    	Individual[] newIndiv = new Individual[2];
        newIndiv[0] = new Individual();
        newIndiv[1] = new Individual();
        
        for(int i = 0; i< Individual.SIZE; i++){
        	 if(Math.random() > 0.5)
             	newIndiv[0].setGene(i, indiv1.getGene(i));             
        	 else
        		 newIndiv[0].setGene(i, indiv2.getGene(i));
        	 if(Math.random() > 0.5)
              	newIndiv[1].setGene(i, indiv1.getGene(i));             
         	 else
         		 newIndiv[1].setGene(i, indiv2.getGene(i));
        }        
        return newIndiv;        
    }
	
}