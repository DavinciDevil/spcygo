--无参函数
function hello()
print 'hello'
end
--带1个参函数
function test(str)
print('data from java is:'..str)
return 'haha'
end

--带两个参函数
function test1(str1,str2)
print('data from java is:'..str1 .. 'and ' ..str2)
return 'haha2'
end

--使用luajava创建java类的实例（对象）
function callJavaInstance()
local demo = luajava.newInstance("com.spc.test.Demo")
--调用对象方法
demo:calledByLua1("Test call java in lua0")
end

--使用luajava绑定一个java类
function callJavaStatic()
local demo_method = luajava.bindClass("com.spc.test.Demo");
--调用类的静态方法/变量
print(demo_method:calledByLua("test call static java function in lua"))
-- 使用绑定类创建类的实例（对象）
local demo_instance = luajava.new(demo_method)
-- 调用对象方法
demo_instance:calledByLua1("Test call java in lua1")
end