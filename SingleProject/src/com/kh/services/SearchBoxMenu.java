package com.kh.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.persistence.PPab_MainDao;

public class SearchBoxMenu implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String index1 = "menu";
		String code1 = "%M%";
		String index2 = "community";
		String code2 = "%C%";
		String index3 = "event";
		String code3 = "%E%";
		List<Map<String, Object>> list1 = mainDao.menu(index1, code1);
		List<Map<String, Object>> list2 = mainDao.menu(index2, code2);
		List<Map<String, Object>> list3 = mainDao.menu(index3, code3);
		int size1 = list1.size();
		int size2 = list2.size();
		int size3 = list3.size();
		int maxSize = Math.max(size1, size2);
		maxSize = Math.max(maxSize, size3);
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < maxSize; i++) {
			JSONObject jsonObject = new JSONObject();
			if (size1 > i) {
				jsonObject.put("menu", list1.get(i).get("menu"));
			} else {
				jsonObject.put("menu", "");
			}
			if (size2 > i) {
				jsonObject.put("community", list2.get(i).get("community"));
			} else {
				jsonObject.put("community", "");
			}
			if (size3 > i) {
				jsonObject.put("event", list3.get(i).get("event"));
			} else {
				jsonObject.put("event", "");
			}
			jsonArray.add(jsonObject);
		}
//		for (Map<String, Object> map : list1) {
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("menu", map.get("menu"));
//			jsonObject.put("community", map.get("community"));
//			jsonObject.put("event", map.get("event"));
//			jsonArray.add(jsonObject);
//		}
//		for (Map<String, Object> map : list2) {
//			JSONObject jsonObject = new JSONObject();
//			
//			jsonArray.add(jsonObject);
//		}
//		for (Map<String, Object> map : list3) {
//			JSONObject jsonObject = new JSONObject();
//			
//			jsonArray.add(jsonObject);
//		}
		String data = jsonArray.toJSONString();
		request.setAttribute("data", data);
		return "data";
	}

}
