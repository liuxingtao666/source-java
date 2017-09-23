package com;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.bo.LogData;
import com.bo.LogRec;

/**
 * DMS客户端
 * 该类用于读取unix系统日志文件
 * 并将匹配成对的数据发送给服务器
 * @author Administrator
 *
 */
public class DMSClient {
	/**
	 * 用来表示unix系统日志文件wtmpx
	 */
	private File logFile;
	
	/**
	 * 用来表示保存解析后的日志文件log.txt
	 */
	private File textLogFile;
	
	/**
	 * 用来表示上次读取系统日志文件后的位置
	 * last-position.dat
	 */
	private File lastPositionFile;
	
	/**
	 * 配对成功的日志文件
	 */
	private File logRecFile;
	
	/**
	 * 没有配对成功的日志文件
	 */
	private File loginLogFile;
	
	
	
	/**
	 * 用来表示一次解析的日志条数
	 */
	private int batch;
	
	public DMSClient(){
		try {
			//每次解析10条
			batch = 10;
			
			//unix系统日志文件
			logFile 
				= new File("wtmpx");
			
			//解析后的日志文件
			textLogFile
				= new File("log.txt");
			
			//记录上次读取位置的文件
			lastPositionFile
				= new File("last-position.dat");
			
			//配对成功的日志文件
			logRecFile 
				= new File("logrec.txt");
			
			//没有配对成功的日志文件
			loginLogFile
				= new File("login.txt");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取上一次读取系统日志文件的位置
	 * 以便继续后续的读取工作
	 * @return
	 */
	public long getLastPosition(){
		/*
		 * 思路:
		 * 我们先判断保存上次读取到的位置
		 * 这个文件是否存在，不存在说明
		 * 第一次读取。
		 * 若存在就读取这个文件中的数字。 
		 * 还要考虑读取的数字(上次读取的位置)
		 * 是否小于文件的总长度，以便我们判断
		 * 文件是否还有内容可以读取
		 */
		if(!lastPositionFile.exists()){
			return 0;
		}else{
			//创建RAF读取该文件中的数字
			try {
				RandomAccessFile raf
					= new RandomAccessFile(
						lastPositionFile,"r");
				//读取long值
				long position
					= raf.readLong();
				
				//判断该值是否达到文件末尾
				if(position>=logFile.length()){
					//-1表示没得读了(EOF)
					return -1;
				}else{
					return position;
				}
			} catch (Exception e) {
				e.printStackTrace();
				//出错就返回-1
				return -1;
			}
			
			
		}
		
		
		
	}
	
	
	/**
	 * 读取wtmpx文件并将内容解析后
	 * 写入log.txt文件中
	 * @return  true:解析完毕    false:解析失败
	 */
	public boolean loadAndParseLogs(){
		/*
		 * 有一些环节需要判断，暂时不关心
		 */
		try{
			//创建用于读取wtmpx文件的RAF
			RandomAccessFile raf
				= new RandomAccessFile(
					logFile,"r");
			
			//创建一个集合，用于保存所有解析后的内容
			List<LogData> logs
				= new ArrayList<LogData>();
			
			//从wtmpx文件起始读取位置
			long offset = getLastPosition();
			//判断是否还有内容可以读取
			if(offset < 0){
				//每内容直接返回false
				return false;
			}	
			long lastPosition = offset;
			/*
			 * 循环读取文件，循环batch次
			 */
			for(int i=0;i<batch;i++){
				//计算offset起始位置
				offset = lastPosition + 
				         i * LogData.LOG_LENGTH;
				//让raf移动到offset位置
				raf.seek(offset);
				/*
				 * 开始解析
				 * 1:解析user
				 * 2:解析pid
				 * 3:解析type
				 * 4:解析time
				 * 5:解析host
				 */
				//1
				byte[] userData
					= new byte[LogData.USER_LENGTH];
				raf.read(userData);//读取到user
				String user
					= new String(userData,"iso8859-1").trim();
			
				//2
				raf.seek(LogData.PID_OFFSET+offset);
				int pid = raf.readInt();
			
				//3
				raf.seek(LogData.TYPE_OFFSET+offset);
				short type = raf.readShort();
				
				//4
				raf.seek(LogData.TIME_OFFSET+offset);
				int time = raf.readInt();
				
				//5
				byte[] hostData = new byte[LogData.HOST_LENGTH];
				raf.seek(LogData.HOST_OFFSET+offset);
				raf.read(hostData);
				String host = new String(hostData,"iso8859-1").trim();
				
				/*
				 * 当解析完毕后，将信息保存到一个
				 * LogData对象中，并存入集合
				 */
				LogData logData
					= new LogData(user,pid,type,time,host);
				
				logs.add(logData);
			}
			
			/*
			 * 将10条解析后的数据写入log.txt文件
			 */
//			FileOutputStream fos
//				= new FileOutputStream(
//						textLogFile
//				  );
//			PrintWriter writer
//				= new PrintWriter(fos);
//			
//			for(LogData log : logs){
//				writer.println(log);
//			}
			//重用方法
			saveList(logs,textLogFile);
			
			
			/*
			 * 当完成解析工作后，记录本次读取
			 * 系统日志文件的位置，以便下次
			 * 继续工作。
			 */
			lastPosition
				= raf.getFilePointer();
			
			DataOutputStream dos
				= new DataOutputStream(
					new FileOutputStream(
						lastPositionFile
					)
				  );
			dos.writeLong(lastPosition);
			
			dos.close();
//			writer.close();//上边注释了
			raf.close();
		}catch(Exception e){
			
		}
		
		return true;
	}
	
	/**
	 * 读取log.txt文件，将每一条日志解析为
	 * 一个LogData对象，并存入集合
	 * 最终将集合返回
	 * @return
	 */
	public List<LogData> loadLogData(File file){
		List<LogData> list
			= new ArrayList<LogData>();
		
		try {
			BufferedReader br
				= new BufferedReader(
					new FileReader(
						file	
					)
				);
			//读取的一条数据
			String log = null;
			
			while((log = br.readLine())!=null){
				/*
				 * log:
				 * tongxy,15332,8,1189750691,192.168.1.65
				 */
				//根据","拆分
				String[] data = log.split(",");
				
				String user = data[0];
				int pid = Integer.parseInt(data[1]);
				short type = Short.parseShort(data[2]);
				int time = Integer.parseInt(data[3]);
				String host = data[4];
				
				//创建一个LogData对象
				LogData logData 
					= new LogData(user,pid,type,time,host);
				//存入集合
				list.add(logData);
			}
			//关闭流
			br.close();
			
		} catch (Exception e) {
			
		}
		return list;
	}
	
	
	/**
	 * 将给定的List集合中的元素的toString()
	 * 方法返回的字符串作为一行顺序的写入
	 * 给定的文件中
	 * @param list
	 * @param file
	 */
	public void saveList(
				List list,File file){
		try {
			
			PrintWriter writer
				= new PrintWriter(
					file	
				);
			
			for(Object o : list){
				writer.println(o);
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据给定的登入日志，在给定的集合中
	 * 匹配对应的登出日志，若匹配成功
	 * 就创建一个LogRec对象并返回
	 * 若没有找到匹配的，就返回null
	 * @param login
	 * @param list
	 * @return
	 */
	public LogRec matchLogOut(
				LogData login,
				List<LogData> list){
		
		for(LogData log : list){
			try{
				LogRec logRec
					= new LogRec(login,log);
				return logRec;
			}catch(Exception e){				
			}
		}
		return null;
	}
	
	/**
	 * 匹配成对日志
	 * 
	 * 思路:
	 *  读取log.txt文件，将第一步解析出的
	 *  10条日志进行配对。
	 *  
	 *  配对规则是用户名相同，进程ID相同，
	 *  类型一个是7一个是8，并且主机(host)相同的。
	 *  
	 *  将配对成功的日志写入一个文件logrec.txt
	 *  将没有配对成功的日志(登入日志)写入login.txt
	 *  
	 *  没有配对成功的日志将在下次配对时再重新进行
	 *  配对工作
	 * @return
	 */
	public boolean matchLogs(){
		/*
		 * 
		 * 必要的判断工作，暂时不处理
		 * 
		 */
		/*
		 * 1:先从log.txt文件中读取解析出的日志
		 * 2:查看有没有上次没匹配成对的日志，若
		 *   有则将它们读出和这次解析的日志放在
		 *   一起，等待配对
		 * 3:开始配对，将配对成功的日志存入一个
		 *   LogRec对象中，并放入集合
		 *   将没有配对成功的放入另一个集合
		 * 4:将配对成功的日志写入logrec.txt
		 * 5:将没有配对成功的日志写入login.txt  
		 *   
		 */
		
		//1 
		List<LogData> list
			= loadLogData(textLogFile);
		
		//2
		if(loginLogFile.exists()){
			list.addAll(
				loadLogData(
					loginLogFile
				)
			);
		}
		
		
		//3
		List<LogRec> matched
			= new ArrayList<LogRec>();
		
		List<LogData> loginList
			= new ArrayList<LogData>();
		
		/*
		 * 遍历所有待配对的日志
		 * 并进行配对工作 
		 */
		for(LogData logData : list){
			//根据登入找登出
			if(logData.getType() == 7){
				LogRec logrec
					= matchLogOut(
						logData,list);
				//没有配对的
				if(logrec == null){
					loginList.add(logData);
				}else{
				//成功配对的	
					matched.add(logrec);
				}
			}
		}
		
		//4
		//将统计后的数据各自写入不同文件中
		//写配对数据
		saveList(matched,logRecFile);
		
		//写没有配对成功的数据
		saveList(loginList,loginLogFile);
		
		/*
		 * 当归类完毕后，第一步生成的log.txt
		 * 文件就可以删除了
		 */
		textLogFile.delete();
		
		return true;//配对完毕
	}
	
	
	/**
	 * 第三步:
	 * 将配对成功的数据发送至服务器
	 * @return
	 */
	public boolean sendLogs(){
		/*
		 * 思路：
		 * 首先将logrec.txt中的每行配对
		 * 成功的数据读取出来。
		 * 
		 * 然后连接服务器，将这些数据发送过去
		 * 
		 * 发送完毕后，将logrec.txt文件
		 * 删除掉。
		 * 
		 */
		try {
			//1 读取配对成功的数据
			BufferedReader reader
				= new BufferedReader(
					new FileReader(
						logRecFile
					)
				);
			//保存所有配对成功的信息
			List<String> logrecList
				= new ArrayList<String>();
			
			String rec = null;
			while((rec = reader.readLine())!=null){
				logrecList.add(rec);
			}
			reader.close();
			
			//2
			Socket socket 
				= new Socket(
					"localhost",8088);
			
			OutputStream out
				= socket.getOutputStream();
			
			OutputStreamWriter osw
				= new OutputStreamWriter(
					out,"utf-8"	
				);
			
			PrintWriter pw
				= new PrintWriter(
					osw,true	
				);
			//将匹配数据发送至服务器
			for(String log:logrecList){
				pw.println(log);
			}
			
			//发送完毕与服务器断开连接
			socket.close();

			//删除logrec.txt
			logRecFile.delete();
			return true;
		} catch (Exception e) {

		}
		
		
		return false;
	}
	
	
	/**
	 * 启动客户端的方法
	 */
	public void start(){
		//1第一步：读取系统日志并解析
		loadAndParseLogs();
		
		//2第二步:将解析后的日志进行配对
		matchLogs();
		
		//3第三步:将配对成功的信息发送至服务器
		sendLogs();
	}
	
	public static void main(String[] args) {
		DMSClient client 
			= new DMSClient();
		client.start();
	}
}



