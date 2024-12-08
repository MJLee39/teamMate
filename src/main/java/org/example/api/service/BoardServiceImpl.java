package org.example.api.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.GetBoardResponseDTO;
import org.example.domain.board.Board;
import org.example.domain.board.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

        private final BoardRepository boardRepository;

        @Override
        public List<GetBoardResponseDTO> findAllBoards(){
                return boardRepository.findAll()
                        .stream()
                        .map(GetBoardResponseDTO::fromEntity)
                        .collect(Collectors.toList());
        };

        @Override
        public GetBoardResponseDTO getBoardById(Long boardID){
                Board board = boardRepository.findById(boardID).orElseThrow(
                        () -> new EntityNotFoundException("Board Not Found")
                );

                GetBoardResponseDTO response = GetBoardResponseDTO.fromEntity(board);
                return response;
        }
}
