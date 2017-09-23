package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.bo.LogData;

/**
 * DMS�ͻ���
 * �������ڶ�ȡunixϵͳ��־�ļ�
 * ����ƥ��ɶԵ����ݷ��͸�������
 * @author Administrator
 *
 */
public class DMSClient {
	/**
	 * ������ʾunixϵͳ��־�ļ�wtmpx
	 */
	private File logFile;
	
	/**
	 * ������ʾ������������־�ļ�log.txt
	 */
	private File textLogFile;
	
	/**
	 * ������ʾһ�ν�������־����
	 */
	private int batch;
	
	public DMSClient(){
		try {
			//ÿ�ν���10��
			batch = 10;
			//unixϵͳ��־�ļ�
			logFile = new File("wtmpx");
			//���������־�ļ�
			textLogFile = new File("log.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡwtmpx�ļ��������ݽ�����
	 * д��log.txt�ļ���
	 * @return  true:�������    false:����ʧ��
	 */
	public boolean loadAndParseLogs(){
		/*
		 * ��һЩ������Ҫ�жϣ���ʱ������
		 */
		try{
			//�������ڶ�ȡwtmpx�ļ���RAF
			RandomAccessFile raf
				= new RandomAccessFile(
					logFile,"r");
			
			//����һ�����ϣ����ڱ������н����������
			List<LogData> logs
				= new ArrayList<LogData>();
			
			//��wtmpx�ļ���ʼ��ȡλ��
			int offset = 0;
			/*
			 * ѭ����ȡ�ļ���ѭ��batch��
			 */
			for(int i=0;i<batch;i++){
				//����offset��ʼλ��
				offset = i * LogData.LOG_LENGTH;
				//��raf�ƶ���offsetλ��
				raf.seek(offset);
				/*
				 * ��ʼ����
				 * 1:����user
				 * 2:����pid
				 * 3:����type
				 * 4:����time
				 * 5:����host
				 */
				//1
				byte[] userData
					= new byte[LogData.USER_LENGTH];
				raf.read(userData);//��ȡ��user
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
				 * ��������Ϻ󣬽���Ϣ���浽һ��
				 * LogData�����У������뼯��
				 */
				LogData logData
					= new LogData(user,pid,type,time,host);
				
				logs.add(logData);
			}
			
			/*
			 * ��10�������������д��log.txt�ļ�
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
	 * �����ͻ��˵ķ���
	 */
	public void start(){
		//1��һ������ȡϵͳ��־������
		loadAndParseLogs();
	}
	
	public static void main(String[] args) {
		DMSClient client 
			= new DMSClient();
		client.start();
	}
}



