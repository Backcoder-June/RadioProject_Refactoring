package board;

import org.springframework.stereotype.Component;

@Component
public class BoardDTO {

	private int seq;

	private String title;

	private String contents;

	private String writer;

	private int secret;

	private int viewCount;

	private String writingTime;

	private int likeCount;

	private int likeCheck;

	public BoardDTO() {
	}

	public BoardDTO(int seq, String title, String contents, String writer, int secret, int viewCount, int likeCount,
			int likeCheck, String writingTime) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.secret = secret;
		this.viewCount = viewCount;
		this.likeCount = likeCount;
		this.likeCheck = likeCheck;
		this.writingTime = writingTime;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}

	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", secret=" + secret + ", viewCount=" + viewCount + ", writingTime=" + writingTime + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getWritingTime() {
		return writingTime;
	}

	public void setWritingTime(String writingTime) {
		this.writingTime = writingTime;
	}
}