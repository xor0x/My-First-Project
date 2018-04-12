package com.project.test;

import java.net.*;

import java.io.*;



class Client {



public static void main(String[] args) {

try {

Socket clientSocket = null;

// 127.0.0.1 - IP ��� ������� Server, 1234 - ����

clientSocket = new Socket("172.20.10.2", 1234);



BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));



String fuser, fserver;



out = new PrintWriter(clientSocket.getOutputStream(), true);

in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



while ((fuser = inu.readLine()) != null) {

out.println(fuser);

fserver = in.readLine();

System.out.println(fserver);

if (fuser.equalsIgnoreCase("close")) {

break;

}

if (fuser.equalsIgnoreCase("exit")) {

break;

}

}



out.close();

in.close();

inu.close();

clientSocket.close();

} catch (Exception e) {

System.out.println(e.getMessage());

}



}

}