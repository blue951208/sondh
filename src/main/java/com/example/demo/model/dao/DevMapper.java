package com.example.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.Note;

@Repository
@Mapper
public interface DevMapper {
	List<Note> getAllNoteList();
	
	Note getNote(int no);
	
	void insertNote(Note note);
	
	void updateNote(Note note);
	
	void deleteNote(int no);
}
