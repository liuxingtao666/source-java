package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.bo.LogData;

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
	 * 用来表示一次解析的日志条数
	 */
	private int batch;
	
	public DMSClient(){
		try {
			//每次解析10条
			batch = 10;
			//unix系统日志文件
			logFile = new File("wtmpx");
			//解析后的日志文件
			textLogFile = new File("log.txt");
		} catch (Exception e) {
			e.printStackTrace();
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
			int offset = 0;
			/*
			 * 循环读取文件，循环batch次
			 */
			for(int i=0;i<batch;i++){
				//计算offset起始位置
				offset = i * LogData.LOG_LENGTH;
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
			FileOutputStream fos
				= new FileOutputStream(
						textLogFile
				  );
			PrintWriter writer
				= new PrintWriter(fos);
			
			for(LogData log : logs){
				writer.println(log);
			}
			
			writer.close();
			raf.close();
			
		}catch(Exception e){
			
		}
		
		return false;
	}
	
	/**
	 * 启动客户端的方法
	 */
	public void start(){
		//1第一步：读取系统日志并解析
		loadAndParseLogs();
	}
	
	public static void main(String[] args) {
		DMSClient client 
			= new DMSClient();
		client.start();
	}
}



