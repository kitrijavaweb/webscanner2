package pattern.servlet;

public class testjavas {
	public static void main(String[] args) {
		int page = 22;

		int countList = 10;

		int countPage = 10;


		int totalCount = 255;


		int totalPage = totalCount / countList;


		if (totalCount % countList > 0) {

		    totalPage++;

		}



		if (totalPage < page) {

		    page = totalPage;

		}



		int startPage = ((page - 1) / 10) * 10 + 1;

		int endPage = startPage + countPage - 1;



		if (endPage > totalPage) {

		    endPage = totalPage;

		}



		if (startPage > 1) {

		    System.out.print("<a href=\"?page=1\">ó��</a>");

		}



		if (page > 1) {

		    System.out.println("<a href=\"?page=" + (page - 1)  + "\">����</a>");

		}



		for (int iCount = startPage; iCount <= endPage; iCount++) {

		    if (iCount == page) {

		        System.out.print(" <b>" + iCount + "</b>");

		    } else {

		        System.out.print(" " + iCount + " ");

		    }

		}


		if (page < totalPage) {
		    
		    System.out.println("<a href=\"?page=" + (page + 1)  + "\">����</a>");

		}



		if (endPage < totalPage) {

		    System.out.print("<a href=\"?page=" + totalPage + "\">��</a>");

		}
		
	}
}
