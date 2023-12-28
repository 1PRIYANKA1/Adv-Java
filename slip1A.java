import java.net.*;
class slip1A
{
public static void main(String args[])
throws UnknownHostException{
InetAddress i = InetAddress.getByName("localhost");
System.out.println(i);
System.out.println("IP Address:"+i.getHostAddress()+
"\nName:"+i.getHostName());
}
}




                                                               