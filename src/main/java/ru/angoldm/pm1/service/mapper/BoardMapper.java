package ru.angoldm.pm1.service.mapper;

import org.springframework.stereotype.Component;
import ru.angoldm.pm1.dto.BoardDto;
import ru.angoldm.pm1.entity.Board;

@Component
public class BoardMapper {

    public BoardDto toDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setName(board.getName());
        boardDto.setProjectId(board.getProjectId());
        return boardDto;
    }

    public Board toEntity(BoardDto boardDto) {
        Board board = new Board();
        board.setId(boardDto.getId());
        board.setName(boardDto.getName());
        board.setProjectId(boardDto.getProjectId());
        return board;
    }
}
