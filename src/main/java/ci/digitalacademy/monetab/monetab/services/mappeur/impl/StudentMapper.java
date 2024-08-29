package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.services.dto.StudentDTO;

public final class StudentMapper {

    private StudentMapper() {
    }

    public static StudentDTO toDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setNom(student.getNom());
        studentDTO.setPrenom(student.getPrenom());
        studentDTO.setAge(student.getAge());
        studentDTO.setGenre(student.getGenre());
        studentDTO.setTelephone(student.getTelephone());
        studentDTO.setVille(student.getVille());
        studentDTO.setMatricule(student.getMatricule());
        studentDTO.setClasse(student.getClasse());
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setNom(studentDTO.getNom());
        student.setPrenom(studentDTO.getPrenom());
        student.setAge(studentDTO.getAge());
        student.setGenre(studentDTO.getGenre());
        student.setTelephone(studentDTO.getTelephone());
        student.setVille(studentDTO.getVille());
        student.setMatricule(studentDTO.getMatricule());
        student.setClasse(studentDTO.getClasse());
        return student;
    }

}
