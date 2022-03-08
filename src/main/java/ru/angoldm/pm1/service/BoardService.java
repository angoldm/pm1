package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.BoardDto;

import java.util.List;
public interface BoardService {

    BoardDto createBoard(BoardDto boardDto);

    List<BoardDto> findAll();

    BoardDto updateBoard(BoardDto boardDto, Long id);

    void delete(Long id);
}
