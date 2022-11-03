package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.DevMapper;
import com.example.demo.model.dto.Note;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DevServiceImpl implements DevService{
	@Autowired
	DevMapper devMapper;
	
	@Override
	public List<Note> getAllNoteList() {
		return devMapper.getAllNoteList();
	}

	@Override
	public void insertNote(Note note) {
		devMapper.insertNote(note);
	}

	@Override
	public Note getNote(int no) {		
		return devMapper.getNote(no);
	}

	@Override
	public void updateNote(Note note) {
		devMapper.updateNote(note);		
	}

}
