package edu.mum.waa;

public class Welcome implements iPages{

	@Override
	public BBHttpResponse getPageAndResponse(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		// TODO Auto-generated method stub
		StringBuilder response = new StringBuilder();
		response.append("<!DOCTYPE html>");
		response.append("<html>");
		response.append("<head>");
		response.append("<title>Welcome</title>");
		response.append("</head>");
		response.append("<body>");
		response.append("<h1>This is the welcome page</h1>");
		response.append("</body>");
		response.append("</html>");

		httpResponse.setStatusCode(200);
		httpResponse.setMessage(response.toString());

		return httpResponse;
	}

}
