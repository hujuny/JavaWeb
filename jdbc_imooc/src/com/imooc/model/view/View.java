package com.imooc.model.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.imooc.action.GoddessAction;
import com.imooc.model.Goddess;

public class View {

	private static final String CONTEXT="欢迎来到女神禁区：\n" +
			"下面是女神禁区的功能列表：\n" +
			"[MAIN/M]:主菜单\n" +
			"[QUERY/Q]:查看全部女神的信息\n" +
			"[GET/G]:查看某位女神的详细信息\n" +
			"[ADD/A]:添加女神信息\n" +
			"[UPDATE/U]:更新女神信息\n" +
			"[DELETE/D]:删除女神信息\n" +
			"[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n" +
			"[EXIT/E]:退出女神禁区\n" +
			"[BREAK/B]:退出当前功能，返回主菜单";

	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";

	public static void main(String[] args) throws Exception {
		System.out.println(CONTEXT);
		
		Scanner s=new Scanner(System.in);
		GoddessAction action=new GoddessAction();
		
		String pervious=null;
		Integer step=1;
		Goddess go=null;
		
		while(s.hasNext()){
			String in=s.next();
			if(OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
				System.out.println("您已成功退出女神禁区");
				break;
			}else if(OPERATION_MAIN.equals(in.toUpperCase())
					||OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())){
				step=1;
				pervious=null;
				go=null;
				System.out.println(CONTEXT);
			}else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				List<Goddess> list=action.query();
				for (Goddess goddess : list) {
					System.out.println(goddess.toString());
				}
			}else if(OPERATION_GET.equals(in.toUpperCase())
					||OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_GET.equals(pervious)){
				pervious=OPERATION_GET;
				if(1==step){
					System.out.println("请输入查询的女神ID：");
				}else if(step>1){
					Integer id=null;
					Goddess g;
					try {
						id = Integer.valueOf(in);
						try {
							g = action.get(id);
							if(g==null){
								System.out.println("查询女神信息失败");
							}else{
								System.out.println(g.toString());
							}
						} catch (Exception e) {
							System.out.println("查询女神信息失败");
						}
					} catch (Exception e) {
						System.out.println("请输入正确的女神ID：");
					}
					
				}
				step++;
			}else if(OPERATION_ADD.equals(in.toUpperCase())
					||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(pervious)){
				pervious=OPERATION_ADD;
				if(1==step){
					System.out.println("请输入女神的信息[姓名]：");
				}else if(2==step){
					go=new Goddess();
					go.setUser_name(in);
					System.out.println("请输入女神的信息[年龄]：");
				}else if(3==step){
					Integer age=null;
					try {
						age = Integer.valueOf(in);
						go.setAge(age);
						System.out.println("请输入女神的信息[生日，格式:2014-12-12]：");
					} catch (Exception e) {
						step=2;
						System.out.println("请输入正确女神的信息[年龄]：");
					}
				}else if(4==step){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date birthday=null;
					try {
						birthday = sf.parse(in);
						go.setBirthday(birthday);
						System.out.println("请输入女神的信息[邮箱]：");
					} catch (Exception e) {
						step=3;
						System.out.println("请输入正确女神的信息[生日]：");
					}
				}else if(5==step){
					go.setEmail(in);
					System.out.println("请输入女神的信息[手机号]：");
				}else if(6==step){
					go.setMobile(in);
					try {
						action.add(go);
					} catch (Exception e) {
						System.out.println("新增女神信息失败");
					}
					System.out.println("新增女神信息成功");
					step=1;
					pervious=null;
				}
				if(OPERATION_ADD.equals(pervious)){
					step++;
				}
			}else if(OPERATION_UPDATE.equals(in.toUpperCase())
					||OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_UPDATE.equals(pervious)){
				pervious=OPERATION_UPDATE;
				if(1==step){
					System.out.println("请输入要修改的女神ID：");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							go = action.get(id);
							if(go==null){
								System.out.println("查询女神信息失败");
								step=1;
							}
						} catch (Exception e) {
							System.out.println("查询女神信息失败");
							step=1;
						}
					} catch (Exception e) {
						System.out.println("请输入正确的女神ID：");
						step=1;
					}
					System.out.println("请输入新的女神信息[姓名]，如果不修改该值，请输入-1：");
				}else if(3==step){
					if(-1!=Integer.valueOf(in)){
						go.setUser_name(in);
					}
					System.out.println("请输入新的女神信息[年龄]，如果不修改该值，请输入-1：");
				}else if(4==step){
					Integer age=null;
					try {
						age = Integer.valueOf(in);
						if(-1!=age){
							go.setAge(age);
						}
						System.out.println("请输入新的女神信息[生日，格式:2014-12-12]，如果不修改该值，请输入-1：");
					} catch (Exception e) {
						step=3;
						System.out.println("请输入正确女神的信息[年龄]：");
					}
				}else if(5==step){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date birthday=null;
					try {
						if(-1!=Integer.valueOf(in)){
							birthday = sf.parse(in);
							go.setBirthday(birthday);
						}
						System.out.println("请输入新的女神信息[邮箱]，如果不修改该值，请输入-1：");
					} catch (Exception e) {
						step=4;
						System.out.println("请输入正确女神的信息[生日]：");
					}
				}else if(6==step){
					if(-1!=Integer.valueOf(in)){
						go.setEmail(in);
					}
					System.out.println("请输入新的女神信息[手机号]，如果不修改该值，请输入-1：");
				}else if(7==step){
					if(-1!=Integer.valueOf(in)){
						go.setMobile(in);
					}
					try {
						action.edit(go);
					} catch (Exception e) {
						System.out.println("更新女神信息失败");
					}
					System.out.println("更新女神信息成功");
					step=1;
					pervious=null;
				}
				if(OPERATION_UPDATE.equals(pervious)){
					step++;
				}
			}else if(OPERATION_DELETE.equals(in.toUpperCase())
					||OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_DELETE.equals(pervious)){
				pervious=OPERATION_DELETE;
				if(1==step){
					System.out.println("请输入要删除的女神ID：");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							action.del(id);
							step=1;
							System.out.println("删除女神信息成功");
						} catch (Exception e) {
							System.out.println("删除女神信息失败");
						}
					} catch (Exception e) {
						System.out.println("请输入正确的女神ID：");
						step=1;
					}
				}
				if(OPERATION_DELETE.equals(pervious)){
					step++;
				}
			}else if(OPERATION_SEARCH.equals(in.toUpperCase())
					||OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_SEARCH.equals(pervious)){
				pervious=OPERATION_SEARCH;
				if(1==step){
					System.out.println("请输入要查询的女神信息，支持姓名、手机号查询，如果两个参数都输入则用逗号分隔[user_name=xx,mobile=xx]：");
				}else if(2==step){
					if(in!=null&&in!=""){
						List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
						Map<String, Object> param=null;
						String[] strs=in.split(",");
						for (int i = 0; i < strs.length; i++) {
							String[] strs_s=strs[i].split("=");
							param=new HashMap<String, Object>();
							param.put("name", strs_s[0]);
							param.put("rela", "=");
							param.put("value", "'"+strs_s[1]+"'");
							params.add(param);
						}
						List<Goddess> list=action.query(params);
						if(list!=null&&list.size()>0){
							for (Goddess goddess : list) {
								System.out.println(goddess.toString());
							}
						}else{
							System.out.println("没有查询到女神信息。。。");
						}
						step=1;
					}
				}
				if(OPERATION_SEARCH.equals(pervious)){
					step++;
				}
			}
		}
	}
}
