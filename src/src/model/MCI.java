package model;
import java.io.Serializable;

public class MCI implements Serializable {
		private String icon;		// iconのimage
		private String user_name;	   // ユーザー名
		private String address;		// 住所
		private String freespace;     //一言コメント

		public MCI(String icon, String user_name,String address,String freespace) {
			this.icon = icon;
			this.user_name = user_name;
			this.address = address;
			this.freespace = freespace;
		}

		public MCI() {
			this.icon = "";
			this.user_name = "";
			this.address = "";
			this.freespace = "";
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getFreespace() {
			return freespace;
		}

		public void setFreespace(String freespace) {
			this.freespace = freespace;
		}

}
