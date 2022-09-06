package comment;

public class CommentDTO {
	int comment_seq, seq, secret;
	
	String contents, writer, writingtime;
	
	public int getCommentSeq() {
		return comment_seq;
	}
	public void setCommentSeq(int comment_seq) {
		this.comment_seq = comment_seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
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
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}
}
