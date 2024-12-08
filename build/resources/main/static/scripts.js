const boardListDiv = document.getElementById("board-list");
const boardDetailDiv = document.getElementById("board-detail");
const detailTitle = document.getElementById("detail-title");
const detailContent = document.getElementById("detail-content");
const backButton = document.getElementById("back-button");

// API Base URL
const API_URL = "http://localhost:8080/api/board";

// Fetch and display all boards
async function fetchAllBoards() {
    try {
        const response = await fetch(API_URL);
        const boards = await response.json();

        boardListDiv.innerHTML = "";
        boards.forEach(board => {
            const boardItem = document.createElement("div");
            boardItem.className = "board-item";
            boardItem.textContent = board.title;
            boardItem.addEventListener("click", () => fetchBoardDetail(board.boardId));
            boardListDiv.appendChild(boardItem);
        });
    } catch (error) {
        console.error("Failed to fetch boards:", error);
        boardListDiv.innerHTML = "<p>게시글을 불러오는 데 실패했습니다.</p>";
    }
}

// Fetch and display a single board detail
async function fetchBoardDetail(boardId) {
    try {
        const response = await fetch(`${API_URL}/read/${boardId}`);
        const board = await response.json();

        detailTitle.textContent = board.title;
        detailContent.textContent = board.content;

        boardListDiv.style.display = "none";
        boardDetailDiv.style.display = "block";
    } catch (error) {
        console.error("Failed to fetch board detail:", error);
        alert("게시글을 불러오는 데 실패했습니다.");
    }
}

// Handle back button click
backButton.addEventListener("click", () => {
    boardDetailDiv.style.display = "none";
    boardListDiv.style.display = "block";
});

// Initialize page
fetchAllBoards();
