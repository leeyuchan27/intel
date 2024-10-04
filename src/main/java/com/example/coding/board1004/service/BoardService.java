package com.example.coding.board1004.service;

import com.example.coding.board1004.dto.BoardDTO;
import com.example.coding.board1004.entity.BoardEntity;
import com.example.coding.board1004.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//DTO->Entity (Entity Class)
//Entity->DTO (DTO Class)

@Service
@RequiredArgsConstructor
public class BoardService {

    private  final BoardRepository boardRepository;

    public void save(BoardDTO boardDto) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDto);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList= boardRepository.findAll();
        List<BoardDTO> boardDTOList=new ArrayList<>();
        for(BoardEntity boardEntity: boardEntityList){
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;

    }
}
