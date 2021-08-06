backtrace

// 路径和待选择列表，结果集

func(path, chooseList, result)

 // 符合条件

 result.add();

 return;

 // others

 // path添加item（根据chooseList进行item的选择）

 item = chooseItem(path, chooseList);

 path.add(item)

 backtrace(path, chooseList)

 path.remove(item)