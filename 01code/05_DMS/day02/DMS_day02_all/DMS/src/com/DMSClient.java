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
	 * ������ʾ�ϴζ�ȡϵͳ��־�ļ����λ��
	 * last-position.dat
	 */
	private File lastPositionFile;
	
	/**
	 * ��Գɹ�����־�ļ�
	 */
	private File logRecFile;
	
	/**
	 * û����Գɹ�����־�ļ�
	 */
	private File loginLogFile;
	
	
	
	/**
	 * ������ʾһ�ν�������־����
	 */
	private int batch;
	
	public DMSClient(){
		try {
			//ÿ�ν���10��
			batch = 10;
			
			//unixϵͳ��־�ļ�
			logFile 
				= new File("wtmpx");
			
			//���������־�ļ�
			textLogFile
				= new File("log.txt");
			
			//��¼�ϴζ�ȡλ�õ��ļ�
			lastPositionFile
				= new File("last-position.dat");
			
			//��Գɹ�����־�ļ�
			logRecFile 
				= new File("logrec.txt");
			
			//û����Գɹ�����־�ļ�
			loginLogFile
				= new File("login.txt");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ��һ�ζ�ȡϵͳ��־�ļ���λ��
	 * �Ա���������Ķ�ȡ����
	 * @return
	 */
	public long getLastPosition(){
		/*
		 * ˼·:
		 * �������жϱ����ϴζ�ȡ����λ��
		 * ����ļ��Ƿ���ڣ�������˵��
		 * ��һ�ζ�ȡ��
		 * �����ھͶ�ȡ����ļ��е����֡� 
		 * ��Ҫ���Ƕ�ȡ������(�ϴζ�ȡ��λ��)
		 * �Ƿ�С���ļ����ܳ��ȣ��Ա������ж�
		 * �ļ��Ƿ������ݿ��Զ�ȡ
		 */
		if(!lastPositionFile.exists()){
			return 0;
		}else{
			//����RAF��ȡ���ļ��е�����
			try {
				RandomAccessFile raf
					= new RandomAccessFile(
						lastPositionFile,"r");
				//��ȡlongֵ
				long position
					= raf.readLong();
				
				//�жϸ�ֵ�Ƿ�ﵽ�ļ�ĩβ
				if(position>=logFile.length()){
					//-1��ʾû�ö���(EOF)
					return -1;
				}else{
					return position;
				}
			} catch (Exception e) {
				e.printStackTrace();
				//����ͷ���-1
				return -1;
			}
			
			
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
			long offset = getLastPosition();
			//�ж��Ƿ������ݿ��Զ�ȡ
			if(offset < 0){
				//ÿ����ֱ�ӷ���false
				return false;
			}	
			long lastPosition = offset;
			/*
			 * ѭ����ȡ�ļ���ѭ��batch��
			 */
			for(int i=0;i<batch;i++){
				//����offset��ʼλ��
				offset = lastPosition + 
				         i * LogData.LOG_LENGTH;
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
			//���÷���
			saveList(logs,textLogFile);
			
			
			/*
			 * ����ɽ��������󣬼�¼���ζ�ȡ
			 * ϵͳ��־�ļ���λ�ã��Ա��´�
			 * ����������
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
//			writer.close();//�ϱ�ע����
			raf.close();
		}catch(Exception e){
			
		}
		
		return true;
	}
	
	/**
	 * ��ȡlog.txt�ļ�����ÿһ����־����Ϊ
	 * һ��LogData���󣬲����뼯��
	 * ���ս����Ϸ���
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
			//��ȡ��һ������
			String log = null;
			
			while((log = br.readLine())!=null){
				/*
				 * log:
				 * tongxy,15332,8,1189750691,192.168.1.65
				 */
				//����","���
				String[] data = log.split(",");
				
				String user = data[0];
				int pid = Integer.parseInt(data[1]);
				short type = Short.parseShort(data[2]);
				int time = Integer.parseInt(data[3]);
				String host = data[4];
				
				//����һ��LogData����
				LogData logData 
					= new LogData(user,pid,type,time,host);
				//���뼯��
				list.add(logData);
			}
			//�ر���
			br.close();
			
		} catch (Exception e) {
			
		}
		return list;
	}
	
	
	/**
	 * ��������List�����е�Ԫ�ص�toString()
	 * �������ص��ַ�����Ϊһ��˳���д��
	 * �������ļ���
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
	 * ���ݸ����ĵ�����־���ڸ����ļ�����
	 * ƥ���Ӧ�ĵǳ���־����ƥ��ɹ�
	 * �ʹ���һ��LogRec���󲢷���
	 * ��û���ҵ�ƥ��ģ��ͷ���null
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
	 * ƥ��ɶ���־
	 * 
	 * ˼·:
	 *  ��ȡlog.txt�ļ�������һ����������
	 *  10����־������ԡ�
	 *  
	 *  ��Թ������û�����ͬ������ID��ͬ��
	 *  ����һ����7һ����8����������(host)��ͬ�ġ�
	 *  
	 *  ����Գɹ�����־д��һ���ļ�logrec.txt
	 *  ��û����Գɹ�����־(������־)д��login.txt
	 *  
	 *  û����Գɹ�����־�����´����ʱ�����½���
	 *  ��Թ���
	 * @return
	 */
	public boolean matchLogs(){
		/*
		 * 
		 * ��Ҫ���жϹ�������ʱ������
		 * 
		 */
		/*
		 * 1:�ȴ�log.txt�ļ��ж�ȡ����������־
		 * 2:�鿴��û���ϴ�ûƥ��ɶԵ���־����
		 *   �������Ƕ�������ν�������־����
		 *   һ�𣬵ȴ����
		 * 3:��ʼ��ԣ�����Գɹ�����־����һ��
		 *   LogRec�����У������뼯��
		 *   ��û����Գɹ��ķ�����һ������
		 * 4:����Գɹ�����־д��logrec.txt
		 * 5:��û����Գɹ�����־д��login.txt  
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
		 * �������д���Ե���־
		 * ��������Թ��� 
		 */
		for(LogData logData : list){
			//���ݵ����ҵǳ�
			if(logData.getType() == 7){
				LogRec logrec
					= matchLogOut(
						logData,list);
				//û����Ե�
				if(logrec == null){
					loginList.add(logData);
				}else{
				//�ɹ���Ե�	
					matched.add(logrec);
				}
			}
		}
		
		//4
		//��ͳ�ƺ�����ݸ���д�벻ͬ�ļ���
		//д�������
		saveList(matched,logRecFile);
		
		//дû����Գɹ�������
		saveList(loginList,loginLogFile);
		
		/*
		 * ��������Ϻ󣬵�һ�����ɵ�log.txt
		 * �ļ��Ϳ���ɾ����
		 */
		textLogFile.delete();
		
		return true;//������
	}
	
	
	/**
	 * ������:
	 * ����Գɹ������ݷ�����������
	 * @return
	 */
	public boolean sendLogs(){
		/*
		 * ˼·��
		 * ���Ƚ�logrec.txt�е�ÿ�����
		 * �ɹ������ݶ�ȡ������
		 * 
		 * Ȼ�����ӷ�����������Щ���ݷ��͹�ȥ
		 * 
		 * ������Ϻ󣬽�logrec.txt�ļ�
		 * ɾ������
		 * 
		 */
		try {
			//1 ��ȡ��Գɹ�������
			BufferedReader reader
				= new BufferedReader(
					new FileReader(
						logRecFile
					)
				);
			//����������Գɹ�����Ϣ
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
			//��ƥ�����ݷ�����������
			for(String log:logrecList){
				pw.println(log);
			}
			
			//���������������Ͽ�����
			socket.close();

			//ɾ��logrec.txt
			logRecFile.delete();
			return true;
		} catch (Exception e) {

		}
		
		
		return false;
	}
	
	
	/**
	 * �����ͻ��˵ķ���
	 */
	public void start(){
		//1��һ������ȡϵͳ��־������
		loadAndParseLogs();
		
		//2�ڶ���:�����������־�������
		matchLogs();
		
		//3������:����Գɹ�����Ϣ������������
		sendLogs();
	}
	
	public static void main(String[] args) {
		DMSClient client 
			= new DMSClient();
		client.start();
	}
}



