package board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {

	// 전체 게시물 조회 ( 페이징 )
	public List<BoardDTO> limitBoard(int page);

	// 전체 게시물 수
	public int countBoard();


	//게시물 저장
	public int saveBoard(BoardDTO dto);

	//Seq 로 게시물 조회
	public BoardDTO oneBoard(int seq);

	//게시물 삭제
	public int deleteBoard(int seq);

//게시물 수정 	
	public int editBoard(BoardDTO dto);




// 비밀글 여부
	public int secretBoard(int seq);

// 조회수 업데이트
	public void viewCount(int seq);

	// 검색
	public List<BoardDTO> searchList(HashMap searchType);


	/* 추천 */

	// 추천수 조회
	public int likeCount(int seq);

	// 추천 + 1
	public void updateLike(int bno) throws Exception;

	// 추천 - 1
	public void updateLikeCancel(int bno) throws Exception;

	// 추천 insert
	public void insertLike(int bno,String memberId) throws Exception;

	// 추천 delete
	public void deleteLike(int bno,String memberId)throws Exception;

	// 추천 중복 조회
	public int likeCheck(int bno,String memberId) throws Exception;

}