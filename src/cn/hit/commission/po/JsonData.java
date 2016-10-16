package cn.hit.commission.po;

import java.util.Map;

public class JsonData {
	private Map<String, Object> data;

	public JsonData(Map<String, Object> data) {
		this.data = data;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
