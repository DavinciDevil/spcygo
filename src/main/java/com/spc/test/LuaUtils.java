package com.spc.test;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Created by spring on 2017/9/10.
 */
public class LuaUtils {
    private static Globals globals = JsePlatform.standardGlobals();
    public static Globals loadLuaGlobals(String luaPath){
        //加载脚本文件login.lua，并编译
        globals.loadfile(luaPath).call();
        return globals;
    }

    public static String excuteLuaFun(String funName,String ...args){
        //获取带参函数test
        LuaValue func = globals.get(LuaValue.valueOf(funName));
        //执行test方法,传入String类型的参数参数
        String data = null;
        if(args.length == 0){
            func.call();
        }else if (args.length == 1){
          data  = func.call(LuaValue.valueOf(args[0])).toString();
        }else if(args.length == 2){
            data  = func.call(LuaValue.valueOf(args[0]),LuaValue.valueOf(args[1])).toString();
        }else if(args.length == 3){
            data  = func.call(LuaValue.valueOf(args[0]),LuaValue.valueOf(args[1]),LuaValue.valueOf(args[2])).toString();
        }
        return data;
    }
}
