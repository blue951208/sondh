package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.Note;

public interface DevService {
	public List<Note> getAllNoteList();

	public Note getNote(int no);
	
	public void insertNote(Note note);
	
	public void updateNote(Note note);
}
