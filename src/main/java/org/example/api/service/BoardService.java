package org.example.api.service;

import org.example.api.dto.GetBoardResponseDTO;
import org.example.domain.board.Board;

import java.util.List;

public interface BoardService {

    //모든 board 조회
    List<GetBoardResponseDTO> findAllBoards();

    //boardID로 게시글 조회
    GetBoardResponseDTO getBoardById(Long id);
}
