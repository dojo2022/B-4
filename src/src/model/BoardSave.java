package model;

public class BoardSave {
	private String id;
	private String board_id;
	private String sender_id;
	//id,board_id,sender_id
	/**
	 * @param id
	 * @param board_id
	 * @param sender_id
	 */
	public BoardSave(String id, String board_id, String sender_id) {
		super();
		this.id = id;
		this.board_id = board_id;
		this.sender_id = sender_id;
	}

	public BoardSave() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}


}
