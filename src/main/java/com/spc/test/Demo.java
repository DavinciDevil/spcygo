package com.spc.test;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Created by spring on 2017/9/6.
 */
public class Demo {

    public static void main(String[] args) {
        testLuaCallJ();
    }

    private static String luaPath = "D:\\workspace\\repository\\spcygo\\src\\main\\java\\com\\spc\\test\\LuaDemo.lua";
    //直接把lua代码当做String字符串内嵌到Java代码中：
    public static void writeLuaInJ() {
        String luaStr = "print 'hello,world!'";
        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load(luaStr);
        chunk.call();
    }

    public static void callLuaFuntion() {
        LuaUtils.loadLuaGlobals(luaPath);
        System.out.println(LuaUtils.excuteLuaFun("hello"));
        System.out.println();
        System.out.println(LuaUtils.excuteLuaFun("test","test的参数"));
        System.out.println();
        System.out.println(LuaUtils.excuteLuaFun("test1","test1,的第一个参数","第二个参数"));
    }

    //测试lua调用java
    public static  void testLuaCallJ(){
        LuaUtils.loadLuaGlobals(luaPath);
        LuaUtils.excuteLuaFun("callJavaStatic");
        System.out.println();
        LuaUtils.excuteLuaFun("callJavaInstance");
    }
    //被调用的方法
    public static String calledByLua(String str){
        System.out.println("我是静态方法，被lua调用,lua传入参数为"+str);
        return "我是返回值";
    }
    public void calledByLua1(String str){
        System.out.println("我是普通方法，被lua调用,lua传入参数为"+str);
    }

}
