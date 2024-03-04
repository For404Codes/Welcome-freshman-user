<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="力量属性" prop="strength">
      <el-input v-model="dataForm.strength" placeholder="力量属性"></el-input>
    </el-form-item>
    <el-form-item label="敏捷属性" prop="agility">
      <el-input v-model="dataForm.agility" placeholder="敏捷属性"></el-input>
    </el-form-item>
    <el-form-item label="智力属性" prop="intelligence">
      <el-input v-model="dataForm.intelligence" placeholder="智力属性"></el-input>
    </el-form-item>
    <el-form-item label="经验值" prop="emp">
      <el-input v-model="dataForm.emp" placeholder="经验值"></el-input>
    </el-form-item>
    <el-form-item label="等级" prop="grade">
      <el-input v-model="dataForm.grade" placeholder="等级"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建者用户ID" prop="createdUser">
      <el-input v-model="dataForm.createdUser" placeholder="创建者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="更新者用户ID" prop="updatedUser">
      <el-input v-model="dataForm.updatedUser" placeholder="更新者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="是否删除（1是，0否）" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除（1是，0否）"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          attributeId: 0,
          strength: '',
          agility: '',
          intelligence: '',
          emp: '',
          grade: '',
          createTime: '',
          createdUser: '',
          updateTime: '',
          updatedUser: '',
          isDelete: ''
        },
        dataRule: {
          strength: [
            { required: true, message: '力量属性不能为空', trigger: 'blur' }
          ],
          agility: [
            { required: true, message: '敏捷属性不能为空', trigger: 'blur' }
          ],
          intelligence: [
            { required: true, message: '智力属性不能为空', trigger: 'blur' }
          ],
          emp: [
            { required: true, message: '经验值不能为空', trigger: 'blur' }
          ],
          grade: [
            { required: true, message: '等级不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createdUser: [
            { required: true, message: '创建者用户ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          updatedUser: [
            { required: true, message: '更新者用户ID不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除（1是，0否）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.attributeId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.attributeId) {
            this.$http({
              url: this.$http.adornUrl(`/user/userattributes/info/${this.dataForm.attributeId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.strength = data.userAttributes.strength
                this.dataForm.agility = data.userAttributes.agility
                this.dataForm.intelligence = data.userAttributes.intelligence
                this.dataForm.emp = data.userAttributes.emp
                this.dataForm.grade = data.userAttributes.grade
                this.dataForm.createTime = data.userAttributes.createTime
                this.dataForm.createdUser = data.userAttributes.createdUser
                this.dataForm.updateTime = data.userAttributes.updateTime
                this.dataForm.updatedUser = data.userAttributes.updatedUser
                this.dataForm.isDelete = data.userAttributes.isDelete
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/user/userattributes/${!this.dataForm.attributeId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'attributeId': this.dataForm.attributeId || undefined,
                'strength': this.dataForm.strength,
                'agility': this.dataForm.agility,
                'intelligence': this.dataForm.intelligence,
                'emp': this.dataForm.emp,
                'grade': this.dataForm.grade,
                'createTime': this.dataForm.createTime,
                'createdUser': this.dataForm.createdUser,
                'updateTime': this.dataForm.updateTime,
                'updatedUser': this.dataForm.updatedUser,
                'isDelete': this.dataForm.isDelete
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
