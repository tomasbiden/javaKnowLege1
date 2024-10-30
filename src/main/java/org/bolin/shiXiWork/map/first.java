package org.bolin.shiXiWork.map;

import cn.hutool.json.JSONUtil;
import jodd.util.StringUtil;
import org.bolin.algorithm.Tree.model.TreeNode;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class first {
    private static HashMap<Integer, SqlNode> integerSqlNodeHashMap = new HashMap<>();
        public static class AreaTreeNode {

            private Integer id;
            private String name;
            private List<AreaTreeNode> children;
            private boolean parentNode ;
            private Integer level;
            private Object data;
            public AreaTreeNode(){

            }
            // Getters and Setters

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<AreaTreeNode> getChildren() {
                return children;
            }

            public void setChildren(List<AreaTreeNode> children) {
                this.children = children;
            }

            public boolean isParentNode() {
                return parentNode;
            }

            public void setParentNode(boolean parentNode) {
                this.parentNode = parentNode;
            }

            public Integer getLevel() {
                return level;
            }

            public void setLevel(Integer level) {
                this.level = level;
            }

            public Object getData() {
                return data;
            }

            public void setData(Object data) {
                this.data = data;
            }

        }

    public class SqlNode{
        private Integer id;
        private String name;

        private String childNodeId;
        public SqlNode(Integer id, String name,String childNodeId){
            this.id=id;
            this.name=name;
            this.childNodeId=childNodeId;
        }
        public Integer getId(){
            return  this.id;
        }
        public String getName(){
            return  this.name;
        }
        public  String getChildNodeId(){
            return  this.childNodeId;
        }
    }
    public static  List<Integer> stringToList(String str){
        String[] split = str.substring(1, str.length() - 1).split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            if(!s.isEmpty()){
                list.add(Integer.parseInt(s));
            }

        }
        return list;



    }
    public static AreaTreeNode   dfs(AreaTreeNode root){
        Integer id = root.getId();
        SqlNode sqlNode = integerSqlNodeHashMap.get(id);
        String childNodeId = sqlNode.getChildNodeId();
//        List<Integer> integers = stringToList(childNodeId);
        List<Integer> integers = JSONUtil.toList(childNodeId, Integer.class);



        ArrayList<AreaTreeNode> children = new ArrayList<>();
        if(!integers.isEmpty()){
            for (Integer integer : integers) {
                SqlNode getSqlNode = integerSqlNodeHashMap.get(integer);
                Integer id1 = getSqlNode.getId();
                String name = getSqlNode.getName();

                AreaTreeNode sonTreeNode = new AreaTreeNode();
                sonTreeNode.setId(id1);
                sonTreeNode.setName(name);
                sonTreeNode.setLevel(root.getLevel()+1);

                dfs(sonTreeNode);
                children.add(sonTreeNode);


            }

        }
        root.setChildren(children);

        return root;





    }
    public static void main(String[] args){
        first first = new first();
        SqlNode china = first.new SqlNode(0, "中国", "[1,50]");

        SqlNode guangDong = first.new SqlNode(1, "广东", "[5,8]");
        SqlNode huNang = first.new SqlNode(50, "湖南", "[60,71]");

        SqlNode guangZhou = first.new SqlNode(5, "广州", "[6,7]");
        SqlNode  shenZhen = first.new SqlNode(8, "深圳", "[]");

        SqlNode  huaiHua = first.new SqlNode(71, "怀化", "[]");
        SqlNode  changSha = first.new SqlNode(60, "长沙", "[]");


        SqlNode panYu = first.new SqlNode(7, "番禺", "[]");
        SqlNode huangPu = first.new SqlNode(6, "黄埔", "[]");



        ArrayList<SqlNode> sqlNodes = new ArrayList<>();
        sqlNodes.add(china);
        sqlNodes.add(guangDong);
        sqlNodes.add(huNang);
        sqlNodes.add(guangZhou);
        sqlNodes.add(shenZhen);
        sqlNodes.add(changSha);
        sqlNodes.add(huaiHua);
        sqlNodes.add(panYu);
        sqlNodes.add(huangPu);



        for (SqlNode sqlNode : sqlNodes) {

            integerSqlNodeHashMap.put(sqlNode.getId(),sqlNode);

        }
//        List<Integer> integers = stringToList(shenZhen.getChildNodeId());
//        System.out.println(integers);
        AreaTreeNode areaTreeNode = new AreaTreeNode();
        areaTreeNode.setId(0);
        areaTreeNode.setName("中国");
        areaTreeNode.setLevel(0);

        AreaTreeNode dfs = dfs(areaTreeNode);
        String string = dfs.toString();
//        System.out.println(string);
        List<Integer> list=new ArrayList<Integer>();
        list.add(4);
        list.add(61);

        String jsonStr = JSONUtil.toJsonStr(list);
        System.out.println(jsonStr);
        List<Integer> list1 = JSONUtil.toList(china.getChildNodeId(), Integer.class);
        int i=1;
        List<AreaTreeNode> res = dfs.getChildren();


        String jsonStr1 = JSONUtil.toJsonStr(res);
        System.out.println(jsonStr1);

        String list3=null;
        String jsonStr2 = JSONUtil.toJsonStr(areaTreeNode);
        JSONUtil.toBean(jsonStr2,AreaTreeNode.class);
        boolean b = Objects.nonNull(list3);


        List<Integer> list2 = JSONUtil.toList(list3, Integer.class);




    }
}
