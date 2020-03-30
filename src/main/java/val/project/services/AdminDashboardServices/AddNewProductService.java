package val.project.services.AdminDashboardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import val.project.DTO.forProductCRUDops.BrandInfoFromAdmin;
import val.project.DTO.forProductCRUDops.ProductForAdding;
import val.project.DTO.forProductCRUDops.ProductImagesFromAdmin;
import val.project.DTO.forProductCRUDops.ProductSizeFromAdmin;
import val.project.dao.*;
import val.project.entities.*;
import val.project.services.ImageConvertingService;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddNewProductService {

    private ProductDao productDao;
    private ProductDescriptionDao productDescriptionDao;
    private ProductCategoriesDao productCategoriesDao;
    private ProductSizesDao productSizesDao;
    private BrandDao brandDao;
    private ImageDao imageDao;
    private ImageConvertingService imageConvertingService;

    @Autowired
    public AddNewProductService(ProductDao productDao, ProductDescriptionDao productDescriptionDao, ProductCategoriesDao productCategoriesDao, ProductSizesDao productSizesDao, BrandDao brandDao, ImageDao imageDao, ImageConvertingService imageConvertingService) {
        this.productDao = productDao;
        this.productDescriptionDao = productDescriptionDao;
        this.productCategoriesDao = productCategoriesDao;
        this.productSizesDao = productSizesDao;
        this.brandDao = brandDao;
        this.imageDao = imageDao;
        this.imageConvertingService = imageConvertingService;
    }


    public void addNewProductToDB(ProductForAdding newProduct) {
        Product product = new Product();
        product.setName(newProduct.getName());
        product.setCost(newProduct.getCost());
        product.setVendorCode(newProduct.getVendorCode());
        product.setSimilaritiesIndex(newProduct.getSimilaritiesIndex());
        product.setProductCategories(productCategoriesDao.getById(newProduct.getProductCategories()));
        product.setImages(createImages(newProduct));
        product.setProductDescription(new ProductDescription(
                newProduct.getProductDescription().getSoleMaterial(),
                newProduct.getProductDescription().getSoleHeight(),
                newProduct.getProductDescription().getSex(),
                newProduct.getProductDescription().getSeason()
        ));
        product.setProductSizes(mappingProductSizes(newProduct));
        product.setBrands(mappingBrands(newProduct));

        productDao.save(product);
        System.out.println("----------------Добавил новый товар---------------------");
    }

    private Images createImages(ProductForAdding newProduct) {
        String smallImgName = imageConvertingService.createImageFromBase64(newProduct.getProductImages().getSmallImage(), newProduct.getName(), 0, true);
        List<String> bigImgsNames = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String data = newProduct.getProductImages().getBigImages().get(i);
            String bigImgName = imageConvertingService.createImageFromBase64(data, newProduct.getName(), i + 1, false);
            bigImgsNames.add(bigImgName);
        }
        return new Images(smallImgName, bigImgsNames.get(0), bigImgsNames.get(1), bigImgsNames.get(2));
    }

    private List<ProductSize> mappingProductSizes(ProductForAdding newProduct) {
        List<ProductSizeFromAdmin> data = newProduct.getProductSizes();
        List<ProductSize> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ProductSizeFromAdmin newProdSize = newProduct.getProductSizes().get(i);
            result.add(new ProductSize(newProdSize.getSize(), newProdSize.getLocation()));
        }
        return result;
    }

    private List<Brand> mappingBrands(ProductForAdding newProduct) {
        BrandInfoFromAdmin brand = newProduct.getBrand();
        List<Brand> listOfbrands = new ArrayList<>();
        listOfbrands.add(new Brand(
                brand.getName(),
                brand.getBrandCountry(),
                brand.getManufactureCountry(),
                brand.getManufactureAddress())
        );
        return listOfbrands;
    }

    private void createNewProductCategoryAndGetIt(ProductForAdding newProduct) {
        ProductDescription productDescription = new ProductDescription(
                newProduct.getProductDescription().getSoleMaterial(),
                newProduct.getProductDescription().getSoleHeight(),
                newProduct.getProductDescription().getSex(),
                newProduct.getProductDescription().getSeason()
        );
        productDescriptionDao.save(productDescription);
        System.out.println("______я сохранил новый productDescription");

    }

}
