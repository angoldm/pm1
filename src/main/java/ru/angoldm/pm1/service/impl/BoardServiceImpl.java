package ru.angoldm.pm1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.angoldm.pm1.dto.BoardDto;
import ru.angoldm.pm1.entity.Board;
import ru.angoldm.pm1.exception.BoardIdNotFoundException;
import ru.angoldm.pm1.repository.BoardRepository;
import ru.angoldm.pm1.service.BoardService;
import ru.angoldm.pm1.service.mapper.BoardMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository,
                            BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    @Override
    public BoardDto createBoard(BoardDto boardDto) {
        return boardMapper.toDto(boardRepository.save(boardMapper.toEntity(boardDto)));
    }

    @Override
    public List<BoardDto> findAll() {
        return boardRepository.findAll()
                .stream()
                .map((boardMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public BoardDto updateBoard(BoardDto boardDto, Long id) {
        if (!boardRepository.existsById(id)) throw new BoardIdNotFoundException(id);
        Board board = boardMapper.toEntity(boardDto);
        board.setId(id);
        return boardMapper.toDto(boardRepository.save(board));
    }

    @Override
    public void delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardIdNotFoundException(id));
        boardRepository.delete(board);
    }
}
