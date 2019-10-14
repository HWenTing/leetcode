package T1k_101_200;

public class T1108 {

//	给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
//	所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
	
    public String defangIPaddr(String address) {
//    	return address.replaceAll("\\.", "[.]");//正则的
    	return address.replace(".", "[.]");//非正则的
    }
    
}
