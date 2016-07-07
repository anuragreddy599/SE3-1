package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import registers.CourseRegister;
import registers.DegreeRegister;
import registers.DegreeReqsRegister;
import registers.FacultyRegister;
import registers.GradSchoolRegister;
import registers.SemesterRegister;
import registers.StudentCourseRegister;
import registers.StudentRegister;
import registers.UniversityRegister;

import com.opencsv.CSVReader;
import registers.DegreePlanReqsRegister;

public class FileParser {
	//private static FileParser fileParser = null;
	public FileParser() {
		
	}

	public List<String[]> parse(String url) throws IOException{
		String csvFilename = url;

		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		List<String[]> content;		
		content = csvReader.readAll();

		csvReader.close();
		return content;

	}

	public int saveUniversityInfo(List<String[]> content){		
		String uni[] = content.get(1);
		UniversityRegister uniReg=UniversityRegister.getInstance();
		uniReg.addUniversity(uni[0], uni[1]);
		return 1;
	}

	public int saveGradSchoolInfo(List<String[]> content){		
		String gradSchool[] = content.get(1);
		GradSchoolRegister gradSchoolReg=GradSchoolRegister.getInstance();
		gradSchoolReg.addGradSchool(gradSchool[1], gradSchool[0]);
		return 1;
	}
	
	public int saveSemestersInfo(List<String[]> content){
		content.remove(0);
		int counter=0;
		for(String[] row:content){
			SemesterRegister semReg=SemesterRegister.getInstance();
			semReg.addSemester(row[0], row[1], row[2]);
			counter=counter+1;
		}
		return counter;
	}

	public int saveDegrees(List<String[]> content){	
		content.remove(0);
		int counter=0;
		for(String[] row:content){
			DegreeRegister degreeReg=DegreeRegister.getInstance();
			degreeReg.addDegree(row[0], row[1], row[2],row[3]);
			counter=counter+1;
		}
		return counter;
	}
	
	public int saveCourseInfo(List<String[]> content){
		content.remove(0);
		int counter=0;
		for(String[] row:content){
			//ArrayList<String> preReqs=convertToList(row[8].split(","));
			//ArrayList<String> teachers=convertToList(row[9].split(","));

			CourseRegister courseReg=CourseRegister.getInstance();
			courseReg.addCourse(row[0], row[1], row[2],row[3],row[4],row[5],row[6],
					row[7],row[8],row[9]);
			counter=counter+1;
		}
		return counter;
	}
	
	public int saveFacultyInfo(List<String[]> content){
		content.remove(0);
		int counter=0;
		for(String[] row:content){
			FacultyRegister facultyReg=FacultyRegister.getInstance();
			facultyReg.addFaculty(row[0], row[1], row[2],row[3],row[4],row[5],row[6],
					row[7],row[8]);
			counter=counter+1;
		}
		return counter;
	}
	
	public int saveStudentsInfo(List<String[]> content){	
		int counter=0;
		for(String[] row:content){
			if(!(row[1].equalsIgnoreCase("MSE.ECE"))){
				if(!(row[1].equalsIgnoreCase("MSE.ENGMGT"))){
					StudentRegister studentReg=StudentRegister.getInstance();
					studentReg.addStudent(row[0], row[1], row[2]);
					counter=counter+1;
				}
			}
		}
		return counter;
	}

	public int saveStudentCourseInfo(List<String[]> content){
		int counter=0;
		for(String[] row:content){
			if(CourseRegister.getInstance().getCourse(row[1])!=null){
				StudentCourseRegister studentCourseReg=StudentCourseRegister.getInstance();
				studentCourseReg.addStudentCourse(row[0], row[1], row[2],row[3],row[4]);
				counter=counter+1;
			}
		}
		return counter;
	}

	public void saveDegreeReqs(List<String[]> content){	
		content.remove(0);
		for(int i=0;i<content.size();i=i+3){			
			String row[]=content.get(i);		
			String code=row[0];
			String requiredHours=row[2];
			ArrayList<String> requiredCourses=convertToList(row[4].split(","));

			row=content.get(i+1);
			String electives1Hours=row[2];
			ArrayList<String> electives1Courses=convertToList(row[4].split(","));

			row=content.get(i+2);
			String electives2Hours=row[2];
			ArrayList<String> electives2Courses=convertToList(row[4].split(","));

			DegreeReqsRegister degreeReqsReg=DegreeReqsRegister.getInstance();
			degreeReqsReg.addDegreeReqs(code, requiredHours, electives1Hours, 
					electives2Hours, requiredCourses, electives1Courses, electives2Courses);
		}
	}

	private ArrayList<String> convertToList(String[] arr){
		ArrayList<String> list=new ArrayList<String>();
		if(arr!=null){
			for(int i=0;i<arr.length;i++){
				list.add(arr[i]);
			}
			return list;
		}
		else{
			return null;
		}

	}
        
        public int saveDegreePlanReq(List<String[]> content){
		content.remove(0);
		int counter=0;
		for(String[] row:content){
			DegreePlanReqsRegister degPlanReg=DegreePlanReqsRegister.getInstance();
			degPlanReg.addDegreePlanReqs(row[0], row[1], row[2],row[3],row[4]);
			counter=counter+1;
		}
		return counter;
	}

}
