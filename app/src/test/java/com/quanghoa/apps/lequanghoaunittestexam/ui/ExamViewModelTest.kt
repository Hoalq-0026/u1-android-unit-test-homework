package com.quanghoa.apps.lequanghoaunittestexam.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.quanghoa.apps.lequanghoaunittestexam.model.DiscountPercent
import com.quanghoa.apps.lequanghoaunittestexam.model.UserClassType
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExamViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExamViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = ExamViewModel()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun calculateDiscount_withUserIsUnknownClassType_andAnyTotalPayment() {
        val payment = 4999.0
        val expectDiscount = 0.0
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.UNKNOWN.name)

        val discount = viewModel.discountCalculation()

        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsBlackClassType_andTolTalPaymentBellow3K() {
        val payment = 2999.0
        val expectDiscount = 0.0
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.BLACK.name)

        val discount = viewModel.discountCalculation()

        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsBlackClassType_andTolTalPaymentFrom3K() {
        val payment = 3001.0
        val expectDiscount = payment * DiscountPercent.BLACK_CLASS_MIN_3K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.BLACK.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsBlackClassType_andTolTalPaymentFrom5K() {
        val payment = 5001.0
        val expectDiscount = payment * DiscountPercent.BLACK_CLASS_MIN_5K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.BLACK.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsBlackClassType_andTolTalPaymentFrom10K() {
        val payment = 10001.0
        val expectDiscount = payment * DiscountPercent.BLACK_CLASS_MIN_10K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.BLACK.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }


    @Test
    fun calculateDiscount_withUserIsGoldClassType_andTolTalPaymentBellow3K() {
        val payment = 2999.0
        val expectDiscount = 0.0
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.GOLD.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsGoldClassType_andTolTalPaymentFrom3K() {
        val payment = 3001.0
        val expectDiscount = payment * DiscountPercent.GOLD_CLASS_MIN_3K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.GOLD.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsGoldClassType_andTolTalPaymentFrom5K() {
        val payment = 5005.0
        val expectDiscount = payment * DiscountPercent.GOLD_CLASS_MIN_5K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.GOLD.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsGoldClassType_andTolTalPaymentFrom10K() {
        val payment = 10001.0
        val expectDiscount = payment * DiscountPercent.GOLD_CLASS_MIN_10K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.GOLD.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsSilverClassType_andTolTalPaymentBellow3K() {
        val subTotal = 2999.0
        val expectDiscount = 0.0
        viewModel.setTotalPayment(subTotal)
        viewModel.updateUserClassType(UserClassType.SILVER.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsSilverClassType_andTolTalPaymentFrom3K() {
        val payment = 3001.0
        val expectDiscount = payment * DiscountPercent.SILVER_CLASS_MIN_3K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.SILVER.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsSilverClassType_andTolTalPaymentFrom5K() {
        val payment = 5001.0
        val expectDiscount = payment * DiscountPercent.SILVER_CLASS_MIN_5K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.SILVER.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

    @Test
    fun calculateDiscount_withUserIsSilverClassType_andTolTalPayment10K() {
        val payment = 10001.0
        val expectDiscount = payment * DiscountPercent.SILVER_CLASS_MIN_10K_DISCOUNT_PERCENT
        viewModel.setTotalPayment(payment)
        viewModel.updateUserClassType(UserClassType.SILVER.name)
        val discount = viewModel.discountCalculation()
        Assert.assertEquals(expectDiscount, discount, 0.0)
    }

}