package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.BoardDto;

import java.util.List;
public interface BoardService {

    BoardDto createBoard(BoardDto boardDto);

    List<BoardDto> findAll();

    void delete(Long id);
}
