package com.company.payments.Mapper;

public class MapperHelper {

//	private static ModelMapper getModelMapperConfigurado(MatchingStrategy matchingStrategy) {
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(matchingStrategy != null ? matchingStrategy : MatchingStrategies.STRICT);
//		return modelMapper;
//	}
//	
//	public static Rotina converterRequestParaModel(RotinaRequest request) {
//		return converterRequestParaModel(request, null);
//	}
//
//	public static Rotina converterRequestParaModel(RotinaRequest request, MatchingStrategy matchingStrategy) {
//		
//		ModelMapper modelMapper = getModelMapperConfigurado(matchingStrategy);
//		return modelMapper.map(request, Rotina.class);
//	}
//	
//	public static RotinaResponse converterModelParaResponse(Rotina rotina) {
//		return converterModelParaResponse(rotina, null);
//	}
//	
//	public static RotinaResponse converterModelParaResponse(Rotina rotina, MatchingStrategy matchingStrategy) {
//		
//		ModelMapper modelMapper = getModelMapperConfigurado(matchingStrategy);
//		return modelMapper.map(rotina, RotinaResponse.class);
//	}
//	
//	public static List<RotinaResponse> converterListaModelEmListaResponse(List<Rotina> rotinas){
//		return converterListaModelEmListaResponse(rotinas, null);
//	}
//	
//	public static List<RotinaResponse> converterListaModelEmListaResponse(List<Rotina> rotinas, MatchingStrategy matchingStrategy){
//		
//		List<RotinaResponse> responses = new ArrayList<>();
//				
//		for(Rotina rotina: rotinas) {
//			responses.add(converterModelParaResponse(rotina));
//		}
//		
//		return responses;
//	}
}
